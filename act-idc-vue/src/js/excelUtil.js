/**
 * Created by fmj on 2017/4/12.
 *
 * 发送请求到后端,浏览器直接下载文件
 */
/* eslint-disable */
require('script-loader!file-saver')
require('script-loader!./blobUtil')
require('script-loader!xlsx/dist/xlsx.core.min')

/**
 * 导出excel
 * @param excel 前端返回的 ExportUtil 对象
 */
export const exportExcelByExportUtil = excel => {
  if (excel.exportType === 1) {
    let {header, dataName, dataList, fileName} = excel.excelJsonUtil
    exportJsonExcel(header, dataName, dataList, fileName)
  } else {
    let {filePath, fileName} = excel.excelServerUtil
    exportServerExcel(filePath, fileName)
  }
}


/**
 * Created by fmj on 2017/4/12.
 * Update by fmj on 2017/08/28. 前端导出Excel
 * 通过JsonExportExcel.min.js
 * 处理后端返回的json数据导出excel
 *
 *
 * @param header 表头
 * @param dataName 数据属性
 * @param dataList 数据列表
 * @param fileName 文件名称
 */
function exportJsonExcel(header, dataName, dataList, fileName){
  const exportData = excelFormatJson(dataName,dataList)
  export_json_to_excel(header, exportData, fileName)
}



/**
 * 服务端下载文件
 * @param filePath   下载文件路径
 * @param fileName  下载文件名称
 */
function exportServerExcel(filePath, fileName){
  const elink = document.createElement('a') // 创建a标签
  elink.download = "xxx" // 文件名
  elink.style.display = 'none'
  elink.href = '/act-idc-web/common/export/download.do?filePath=' + filePath + '&fileName=' + fileName
  document.body.appendChild(elink)
  elink.click() // 触发点击a标签事件
  document.body.removeChild(elink)
}

/**
 * json 数据格式
 * @param dataName 数据属性
 * @param jsonData 数据列表
 */
function excelFormatJson(dataName, jsonData){
  return jsonData.map(v => dataName.map(j => {
    return v[j]
  }))
}

function export_json_to_excel (th, jsonData, defaultTitle) {
  /* original data */

  const data = jsonData
  data.unshift(th)
  const ws_name = defaultTitle

  const wb = new Workbook(), ws = sheetFromArrayOfArrays(data)

  /* add worksheet to workbook */
  wb.SheetNames.push(ws_name)
  wb.Sheets[ws_name] = ws

  const wbout = XLSX.write(wb, {bookType: 'xlsx', bookSST: false, type: 'binary'})
  const title = defaultTitle || '列表'
  saveAs(new Blob([s2ab(wbout)], {type: 'application/octet-stream'}), title + '.xlsx')
}


function Workbook () {
  if (!(this instanceof Workbook)) return new Workbook()
  this.SheetNames = []
  this.Sheets = {}
}

function sheetFromArrayOfArrays (data) {
  const ws = {}
  const range = {s: {c: 10000000, r: 10000000}, e: {c: 0, r: 0}}
  for (let R = 0; R !== data.length; ++R) {
    for (let C = 0; C !== data[R].length; ++C) {
      if (range.s.r > R) range.s.r = R
      if (range.s.c > C) range.s.c = C
      if (range.e.r < R) range.e.r = R
      if (range.e.c < C) range.e.c = C
      const cell = {v: data[R][C]}
      if (cell.v == null) continue
      const cellRef = XLSX.utils.encode_cell({c: C, r: R})

      if (typeof cell.v === 'number') cell.t = 'n'
      else if (typeof cell.v === 'boolean') cell.t = 'b'
      else if (cell.v instanceof Date) {
        cell.t = 'n'
        cell.z = XLSX.SSF._table[14]
        cell.v = datenum(cell.v)
      } else cell.t = 's'

      ws[cellRef] = cell
    }
  }
  if (range.s.c < 10000000) ws['!ref'] = XLSX.utils.encode_range(range)
  return ws
}

function datenum (v, date1904) {
  if (date1904) v += 1462
  const epoch = Date.parse(v)
  return (epoch - new Date(Date.UTC(1899, 11, 30))) / (24 * 60 * 60 * 1000)
}

function s2ab (s) {
  const buf = new ArrayBuffer(s.length)
  const view = new Uint8Array(buf)
  for (let i = 0; i !== s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF
  return buf
}






