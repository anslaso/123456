# SSM 商城示例项目

默认配置
- 构建工具：Maven
- Java 版本：11
- 包名：com.anslaso.ssm
- 数据库（默认）：jdbc:mysql://localhost:3306/ssm_demo
  - 用户名：root
  - 密码：root

包含
- 完整代码（controller/service/mapper/entity/config）
- MyBatis mapper XML（resources/mapper）
- 配置文件：web.xml, spring-mvc.xml, applicationContext.xml, mybatis-config.xml
- SQL 脚本：create_tables_and_data.sql
- JSP 视图文件：WEB-INF/views/*.jsp
- 占位运行截图文件（docs/screenshots）

快速部署步骤
1. 导入项目到 IDE（如 IntelliJ IDEA）或在命令行使用 `mvn clean package`
2. 在 MySQL 中创建数据库并导入 SQL:
   - CREATE DATABASE ssm_demo CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
   - 执行 create_tables_and_data.sql
3. 修改数据库连接（如需不同用户名/密码），编辑：
   - src/main/webapp/WEB-INF/applicationContext.xml 中的 dataSource 节点
4. 部署到容器（如 Tomcat 9）：将 target/*.war 部署或使用 IDE 的 Tomcat 配置运行
5. 访问：
   - 登录页: http://localhost:8080/{your-app-context}/user/login
   - 若未改变 context，直接访问 index 页面

测试账号（来自 SQL 脚本）
- alice / pass1
- bob / pass2
