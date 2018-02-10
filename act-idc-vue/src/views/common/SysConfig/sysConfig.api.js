import {ajaxPost} from '../../../js/resultUtil'

export const initialize = params => ajaxPost('/common/systemConfig/initialize.do', params)

export const updateConfig = params => ajaxPost('/common/systemConfig/updateConfig.do', params)

export const resetConfig = params => ajaxPost('/common/systemConfig/resetConfig.do', params)
