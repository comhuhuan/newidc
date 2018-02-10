import {ajaxPost} from '../../../js/resultUtil'

export const editPw = params => ajaxPost('/common/loginVue/modifyPw.do', params)
