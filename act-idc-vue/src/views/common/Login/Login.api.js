import {ajaxPost} from '../../../js/resultUtil'

export const login = params => ajaxPost('/common/loginVue/login.do', params)
