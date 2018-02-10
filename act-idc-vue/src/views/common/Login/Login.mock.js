const Login =
  [{
    path: '/act-idc-web/common/loginVue/login.do',
    data: {
      'code': 200,
      'msg': '请求成功',
      'user': {
        'userId': 'admin',
        'userPassword': 'e10adc3949ba59abbe56e057f20f883e',
        'userName': '系统管理员',
        'userSex': true,
        'userTel': '322753',
        'userMobile': '18771962254',
        'userEmail': 'admin@act-telecom.com',
        'userDescrip': '系统管理员账户',
        'userValid': true,
        'userManager': true,
        'lastTime': 1509415627000,
        'userAmount': 11,
        'userQuestion': '最喜欢的运动',
        'userAnswer': '足球',
        'createDate': 1495017510000,
        'updateDate': 1495017510000,
        'creator': 'admin',
        'modifier': 'admin',
        'valueChanged': false
      },
      'tabSysInfo': {
        'sysName': '基础框架',
        'sysVersion': 'v1.0.0.0',
        'valueChanged': false
      },
      'authorization': [
        {
          'path': '/',
          'component': 'common/Home/Home',
          'name': 1,
          'iconCls': 'fa fa-hand-peace-o fa-lg',
          'hidden': false,
          'children': [
            {
              'path': '/echarts',
              'component': 'common/Echarts/echarts',
              'name': 2,
              'iconCls': 'fa fa-arrow-circle-right fa-lg',
              'hidden': false,
              'children': null,
              'menuName': 'echarts页面'
            }
          ],
          'menuName': '样例1'
        },
        {
          'path': '/',
          'component': 'common/Home/Home',
          'name': 3,
          'iconCls': 'fa fa-hand-peace-o fa-lg',
          'hidden': false,
          'children': [
            {
              'path': '/test',
              'component': 'xxx/Test/test',
              'name': 4,
              'iconCls': 'fa fa-arrow-circle-right fa-lg',
              'hidden': false,
              'children': null,
              'menuName': 'test页面'
            },
            {
              'path': '/export',
              'component': 'xxx/Export/export',
              'name': 5,
              'iconCls': 'fa fa-arrow-circle-right fa-lg',
              'hidden': false,
              'children': null,
              'menuName': '导出页面'
            },
            {
              'path': '/crud',
              'component': 'xxx/CrudSample/crudSample',
              'name': 6,
              'iconCls': 'fa fa-arrow-circle-right fa-lg',
              'hidden': false,
              'children': null,
              'menuName': 'crud样例'
            }
          ],
          'menuName': '样例2'
        },
        {
          'path': '/',
          'component': 'common/Home/Home',
          'name': 7,
          'iconCls': 'fa fa-hand-peace-o fa-lg',
          'hidden': false,
          'children': [
            {
              'path': '/user_config',
              'component': 'common/UserConfig/userConfig',
              'name': 8,
              'iconCls': 'fa fa-arrow-circle-right fa-lg',
              'hidden': false,
              'children': null,
              'menuName': '用户管理'
            },
            {
              'path': '/role_config',
              'component': 'common/RoleConfig/roleConfig',
              'name': 9,
              'iconCls': 'fa fa-arrow-circle-right fa-lg',
              'hidden': false,
              'children': null,
              'menuName': '角色管理'
            },
            {
              'path': '/sys_config',
              'component': 'common/SysConfig/sysConfig',
              'name': 10,
              'iconCls': 'fa fa-arrow-circle-right fa-lg',
              'hidden': false,
              'children': null,
              'menuName': '配置管理'
            }
          ],
          'menuName': '配置页面'
        }
      ]
    }
  }]

export default Login
