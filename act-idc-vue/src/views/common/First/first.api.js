import {ajaxPost} from '../../../js/resultUtil'

export const init = params => {
  return ajaxPost(`/common/firstPage/init.do`, params)
}
