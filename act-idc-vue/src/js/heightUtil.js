/**
 * Created by fmj on 2017/5/4.根据浏览器大小和工具栏高度 得到查询列表table高度
 */

const tableHeight = tool => document.documentElement.clientHeight - tool

export default tableHeight
