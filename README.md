# seata-spring-boot-jpa-demo
此專案分為4個Service，分別為Business(Client)、Order、Stock、Account。主要示範將各個微服務結合Seata來處理分布式事務問題(Distributed Transaction)。

# 啟動專案
- 下載並於本機啟動 seata-server (Windows使用.bat)。
  - 於CMD或PowerShell執行```seata-server.bat -p 8091 -m file```
  - 請使用JDK-8。過去有遇上JDK版本過高無法啟動的問題 [#相似問題](https://www.cxyzjd.com/article/weixin_48232225/109351472)
- 使用all-in-one.sql建立範例SQL環境
- 直接用IDE啟動seata-account-service
- 直接用IDE啟動seata-stock-service
- 直接用IDE啟動seata-orders-service
- 直接用IDE啟動seata-business-service

# 運作邏輯
1. business接口分別呼叫order以及stock服務
2. stock直接依照存貨的count - 1
3. order直接建立訂單後才呼叫account服務確認該用戶帳戶是否有足夠金錢
4. 若account確認用戶有足夠金錢，則扣款後結束整段邏輯
5. (例外狀況) 若account發現用戶金錢不足，則丟出Exception
6. (例外狀況) 各服務則依照當言失敗Transaction的XID使用redo_log做rollback的行為
7. (例外狀況) Rollback後，stock/account/order的table皆和請求前狀態相同不變

# 測試方法

## GET 127.0.0.1:8084/api/business/purchase/commit
依照原邏輯扣款、扣庫存且建立訂單。
回傳: true

## GET 127.0.0.1:8084/api/business/purchase/rollback
stock/account/order的table狀態不變。
回傳: false
