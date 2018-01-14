# com_housingrental_app
房屋出租管理系统
该系统分为移动端子系统和后台管理pc端子系统两部分实现房屋信息的发布和管理以及用户租赁退组等功能。
项目模块划分：
房屋出租管理系统模块说明
--housingrental-parent maven父类模块主要管理模块之间依赖关系
    --basic-common 公共模块存放系统工程功能工具类
        --pom.xml 模块依赖关系描述
    --basic-hibernate 存放系统公共的数据操作方法也就是basedao
        --pom.xml 模块依赖关系描述
    --basic-springmvc 管理项目的springmvc配置和公共controller代码
        --pom.xml 模块依赖关系描述
    --system-usermanage 用户管理模块的父类模块
        --system-user-core 
                model 系统实体类模块描述实体类和数据库关系
                service 业务处理类负责处理业务逻辑交互
                dao 数据交互层数据处理
        --system-user-web 主要是系统的web工程项目负责浏览器和后台服务器逻辑交互
        --system-user-datainterface 主要是系统的外部数据接口工程负责系统外部数据交互
        --pom.xml  模块依赖关系描述
    --housingrental-house-module 房间管理模块
        --housingrental-house-core 
            model 房源信息管理实体类
            service 房源信息管理业务处理类
            dao 数据交互层数据处理
        --housingrental-house-web 房源信息管理web页面与后台服务器交互处理
        --housingrental-house-datainterface 房源信息接口
        --pom.xml 模块依赖关系描述
    --housingrental-rental-module 房屋租赁管理模块
        --housingrental-rental-core 
            model 房屋租赁管理实体类
            service 房屋租赁管理管理业务处理类
            dao 数据交互层数据处理
        --housingrental-rental-datainterface 房屋租赁管理信息数据接口
        --housingrental-rental-web 房屋租赁情况管理web页面与后台服务器交互处理
        --pom.xml 模块依赖关系描述
    --housingrental-web 聚合项目中所有的web模块
    --housingrental-datainterface 集合所有的数据接口模块
