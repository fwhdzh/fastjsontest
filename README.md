将项目clone到本地后，进入项目根目录，执行以下命令：
`mvn clean test`

预期可看到报错信息如下：
```
[INFO] Running edu.iscas.tcse.fastjsontest.TestFastJSON
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.114 s <<< FAILURE! - in edu.iscas.tcse.fastjsontest.TestFastJSON
[ERROR] testFastJSON  Time elapsed: 0.092 s  <<< ERROR!
com.alibaba.fastjson2.JSONException: parseInt error, value : java.util.HashMap
        at edu.iscas.tcse.fastjsontest.TestFastJSON.testFastJSON(TestFastJSON.java:51)
```