const sysConfig =
  [{
    path: '/act-idc-web/common/systemConfig/initialize.do',
    data: {
      'success': {
        'sysConfigList': [
          {
            'configid': 'sys_input',
            'defaultval': '数据框样例',
            'configval': '数据框样例',
            'title': '数据框样例',
            'remark': '数据框样例',
            'showtype': '0',
            'hidden': '1',
            'showseq': 1,
            'valueChanged': false
          },
          {
            'configid': 'sys_select',
            'defaultval': '1',
            'configval': '1',
            'title': '下拉框样例',
            'remark': '下拉框样例',
            'showtype': '1',
            'hidden': '1',
            'showseq': 2,
            'valueChanged': false
          },
          {
            'configid': 'sys_switch',
            'defaultval': 'N',
            'configval': 'N',
            'title': '开关样例',
            'remark': '开关样例',
            'showtype': '2',
            'hidden': '1',
            'showseq': 3,
            'valueChanged': false
          }
        ],
        'groupCount': [
          1,
          1,
          1
        ]
      }
    }
  }]

export default sysConfig
