require('./check-versions')()

process.env.NODE_ENV = 'production'

var ora = require('ora')
var rm = require('rimraf')
var path = require('path')
var chalk = require('chalk')
var webpack = require('webpack')
var config = require('../config')
var webpackConfig = require('./webpack.prod.conf')

var spinner = ora('building for production...')
spinner.start()

 let flag = true
// 修改删除打包文件夹逻辑 防止删除.svn 文件 控制台会报错 但并不影响前端框架的打包 【适用于eclipse】
 rm(path.join(config.build.assetsRoot, config.build.assetsSubDirectory, '/css'), err => {
   if (err) {
     flag = false
     console.log('删除css文件夹失败!')
   }
 })

 rm(path.join(config.build.assetsRoot, config.build.assetsSubDirectory, '/fonts'), err => {
   if (err) {
     flag = false
     console.log('删除fonts文件夹失败!')
   }
 })

 rm(path.join(config.build.assetsRoot, config.build.assetsSubDirectory, '/img'), err => {
   if (err) {
     flag = false
     console.log('删除img文件夹失败!')
   }
 })

 rm(path.join(config.build.assetsRoot, config.build.assetsSubDirectory, '/js'), err => {
   if (err) {
     flag = false
     console.log('删除js文件夹失败!')
   }
 })

 if (flag) {
   webpack(webpackConfig, function (err, stats) {
     spinner.stop()
     if (err) throw err
     process.stdout.write(stats.toString({
       colors: true,
       modules: false,
       children: false,
       chunks: false,
       chunkModules: false
     }) + '\n\n')

     console.log(chalk.cyan('  打包完成.\n'))
     console.log(chalk.yellow(
       '  提示: 前端代码已经打包至服务端 webapp/static路径下.\n' +
       '  项目入口为 webapp/index.html. 若只替换前端代码无需重启tomcat服务\n'
     ))
   })
 }

// 原始版本打包【适用于 idea.webStorm】
//console.log(chalk.red('  压缩打包开始,请等待....\n'))
//rm(path.join(config.build.assetsRoot, config.build.assetsSubDirectory), err => {
//  if (err) throw err
//  webpack(webpackConfig, function (err, stats) {
//    spinner.stop()
//    if (err) throw err
//    process.stdout.write(stats.toString({
//      colors: true,
//      modules: false,
//      children: false,
//      chunks: false,
//      chunkModules: false
//    }) + '\n\n')
//
//    console.log(chalk.cyan('  打包完成.\n'))
//    console.log(chalk.yellow(
//      '  提示: 前端代码已经打包至服务端 webapp/static路径下.\n' +
//      '  项目入口为 webapp/index.html. 若只替换前端代码无需重启tomcat服务\n'
//    ))
//  })
//})
