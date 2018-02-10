# act-alone-vue #
[SVN地址](https://172.31.82.149/svn/IdcSystem2/2trunk/web/cu_code/new_frameword_test/act-alone)

**本项目的定位是前端基础样例框架，集成解决方案请参考 [act-dnsm](https://172.31.82.149/svn/IdcSystem2/2trunk/web/cu_code/product_dns/dnsm2.0.0.0/act-dnsm)**

**注意：该项目目前使用element-ui-1.3.6，vue-2.2.2，webpack-2.2.1**

## 前言
> 本框架适用于独立于老信安项目，不适合基于信安的子系统开发,基于信安的子系统开发参见 [act-sub](https://172.31.82.149/svn/IdcSystem2/2trunk/web/cu_code/new_frameword_test/act-sub)，提供权限控制到按钮级别。所有数据请求采用mockJs,如需与服务端通信请移除main.js中的 import mock from './mock/mock'


相关网站:

 - [vue2.0](http://doc.vue-js.com/v2/api/)
 - [elementUI](http://element.eleme.io/#/zh-CN/)
 - [superagent](https://cnodejs.org/topic/5378720ed6e2d16149fa16bd)
 - [webpackdoc](http://webpackdoc.com/)
 - [fontawesome](http://fontawesome.dashgame.com/)
 - [echarts](http://echarts.baidu.com/)
 - [segmentfault](https://segmentfault.com/)
 - [vue-element-admin](https://github.com/PanJiaChen/vue-element-admin) 
 - [vue component](https://segmentfault.com/a/1190000009090836)
 - [ESLint](https://cnodejs.org/topic/57c68052b4a3bca66bbddbdd)

 **该项目并不是一个脚手架，更倾向于是一个样例框架**

## 功能
- 登录/注销
- 权限验证
- 侧边栏
- 面包屑
- echarts图表
- 导出excel
- 查询列表样例
- 增删改查样例
- mock数据
- ESLint代码规范检查

## 开发
```bash
    # 下载项目
    https://172.31.82.149/svn/IdcSystem2/2trunk/web/cu_code/new_frameword_test/act-alone

    # 安装依赖
    npm install
    //or # 建议不要用cnpm(npm install -g cnpm --registry=https://registry.npm.taobao.org)  安装有各种诡异的bug 可以通过如下操作解决npm速度慢的问题
    npm install --registry=https://registry.npm.taobao.org

    # 本地开发 开启服务
    npm run dev
```

浏览器访问 http://localhost:8083(端口对应 config/index/js 的 dev.port)

## 发布
```bash
    # 前端代码打包
    npm run build
```

## 目录结构
```shell
├── build                      // 构建相关  
├── config                     // 配置相关
├── src                        // 源代码
│   ├── assets                 // 主题 字体等静态资源
│   │     └──theme             // 主题
│   ├── components             // 自定义封装组件
│   ├── image                  // 图片
│   ├── js                     // 工具js,以*Util.js命名
│   ├── mock                   // mock数据js
│   ├── styles                 // 系统样式
│   ├── views                  // 系统页面组件
│   ├── vuex                   // vuex配置
│   ├── App.vue                // 入口页面
│   ├── main.js                // 入口 加载组件 初始化等
│   └── routes.js              // 注册路由
├── .babelrc                   // babel-loader 配置
├── .eslintrc.js               // eslint 配置项
├── .gitignore                 // 忽略项
├── index.html                 // html主页面
└── package.json               // package.json

```

## ESLint代码检查
```bash
安装依赖 cnpm install -g eslint
检查文件 eslint 文件名
自动修复 eslint 文件名 --fix
忽略下一行   // eslint-disable-next-line
忽略代码块   /* eslint-disable */
开启检查    /* esint-enable */


## License

MIT
