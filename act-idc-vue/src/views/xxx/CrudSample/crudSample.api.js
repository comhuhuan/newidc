import {ajaxPost} from '../../../js/resultUtil'

export const pagingList = params => ajaxPost('/xxx/crudSample/pagingList.do', params)
export const save = params => ajaxPost('/xxx/crudSample/save.do', params)
export const remove = params => ajaxPost('/xxx/crudSample/remove.do', params)
