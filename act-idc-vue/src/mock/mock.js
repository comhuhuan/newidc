import Mock from 'mockjs'
import Login from '../views/common/Login/Login.mock'
import first from '../views/common/First/first.mock'
import roleConfig from '../views/common/RoleConfig/roleConfig.mock'
import userConfig from '../views/common/UserConfig/userConfig.mock'
import sysConfig from '../views/common/SysConfig/sysConfig.mock'
import crud from '../views/xxx/CrudSample/crudSample.mock'

function addToMock (list) {
  list.forEach(n => {
    Mock.mock(n.path, n.data)
  })
}

addToMock(Login)
addToMock(first)
addToMock(roleConfig)
addToMock(userConfig)
addToMock(sysConfig)
addToMock(crud)

export default Mock
