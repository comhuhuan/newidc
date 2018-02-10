// 菜单 处理component 表

function renderingSecond (params) {
  params.forEach(item => {
    item.component = require('../views/' + item.component + '.vue')
  })
}

function rendering (params) {
  params.forEach(item => {
    item.component = require('../views/' + item.component + '.vue')
    renderingSecond(item.children)
  })
}

const menu = params => {
  rendering(params)
  return params
}

export default menu
