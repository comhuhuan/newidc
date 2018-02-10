import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
// import './assets/theme/theme-blue/index.css'
import './assets/theme/theme-chalk/index.css'
import VueRouter from 'vue-router'
import store from './vuex/store'
import Vuex from 'vuex'
import routes from './routes'
import 'font-awesome/css/font-awesome.min.css'

// 添加mockjs拦截请求，模拟返回服务器数据
// eslint-disable-next-line
// import mock from './mock/mock'

Vue.use(ElementUI)
Vue.use(VueRouter)
Vue.use(Vuex)

const router = new VueRouter({
  routes
})

const authorization = JSON.parse(sessionStorage.getItem('authorization'))
if (authorization) {
  store.commit('ADD_MENU', authorization)
  router.options.routes = store.state.menuitems
  router.addRoutes(store.state.menuitems)
  store.commit('LOAD_ROUTES')
}

/*
 TODO 独立部署
 */
router.beforeEach((to, from, next) => {
  let user = JSON.parse(sessionStorage.getItem('user'))
  if (!user && to.path !== '/login') {
    next({path: '/login'})
  } else {
    next()
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
