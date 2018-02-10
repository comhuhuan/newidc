import {ajaxPost} from '../../../js/resultUtil'

export const exportExcel = params => ajaxPost('/common/export/export.do', params)
