<template>
    <body>
    <el-row id="box"></el-row>
    <div class="cent-box">
        <el-row class="cent-box-header">
            <h1 class="main-title">信安应用组-基础框架</h1>
            <h2 class="sub-title">stay professional and do your best</h2>
        </el-row>

        <el-row class="cont-main clearfix">

            <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-position="left" label-width="0px">
                <el-form-item prop="userId">
                    <el-input type="text" v-model="ruleForm2.userId" @keyup.enter.native="handleSubmit2"
                              auto-complete="off" placeholder="账号"></el-input>
                </el-form-item>

                <el-form-item prop="password">
                    <el-input type="password" v-model="ruleForm2.password" @keyup.enter.native="handleSubmit2"
                              auto-complete="off" placeholder="密码"></el-input>
                </el-form-item>

                <el-form-item prop="verifyId">
                    <el-input type="text" v-model="ruleForm2.verifyId" @keyup.enter.native="handleSubmit2"
                              auto-complete="off" placeholder="验证码">
                    </el-input>
                    <img v-bind:src=verification class="imgcode" @click="changeVerify()" title="看不清？点击更换">
                </el-form-item>

                <el-form-item style="width:100%;">
                    <el-button type="primary" style="width:100%; " @click.native.prevent="handleSubmit2"
                               :loading="logining">登录
                    </el-button>
                </el-form-item>

                <el-form-item style="width:100%;">
                    <el-button type="primary" style="width:100%; " @click.native.prevent="handleReset2">重置</el-button>
                </el-form-item>


            </el-form>

        </el-row>
    </div>

    <div class="footer">
        <p>vue2.2.2 + element-ui2.0.5 + webpack2.2.1</p>
        <p>designed by <a href="http://www.act-telecom.com/">act</a> & <a href="http://element-cn.eleme.io/#/zh-CN/">eleme.api</a> 2017</p>
    </div>
    </body>
</template>

<script>
  import { login } from './Login.api'
  import { mapActions, mapGetters } from 'vuex'
  import baseUtil from '../../../js/baseUtil'
  import particlesJS from '../../../js/loginUtil.js'
  import '../../../styles/login/login.css'

  export default {
    data () {
      return {
        logining: false,
        verification: '',
        ruleForm: {
          userId: '',
          password: '',
          verifyId: ''
        },
        ruleForm2: {
          userId: '',
          password: '',
          verifyId: ''
        },
        rules2: {
          userId: [
            {required: true, message: '请输入账号', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
            {min: 6, message: '密码长度至少为6位', trigger: 'blur'}
          ],
          verifyId: [
            {required: true, message: '请输入验证码', trigger: 'blur'},
            {min: 4, max: 4, message: '验证码长度必须为4位', trigger: 'blur'}
          ]
        }
      }
    },
    // 增加菜单路由
    computed: {
      ...mapGetters([
        'menuitems',
        'isLoadRoutes'
      ])
    },
    methods: {
      changeVerify: function () {
        let time = new Date().getTime()
        this.verification = '/act-idc-web/common/loginVue/verification.do?d=' + time
      },
      handleReset2 () {
        this.$refs.ruleForm2.resetFields()
      },
      handleSubmit2 () {
        this.$refs.ruleForm2.validate((valid) => {
          if (valid) {
            this.logining = true
            this.ruleForm.userId = baseUtil(this.ruleForm2.userId)
            this.ruleForm.password = baseUtil(this.ruleForm2.password)
            this.ruleForm.verifyId = this.ruleForm2.verifyId
            login(this.ruleForm).then(data => {
              this.logining = false
              let {code, msg, user, tabSysInfo, authorization} = data
              if (code !== 200) {
                this.$message({
                  showClose: true,
                  message: msg,
                  type: 'error'
                })
                this.changeVerify()
              } else {
                sessionStorage.setItem('user', JSON.stringify(user))
                sessionStorage.setItem('tabSysInfo', JSON.stringify(tabSysInfo))
                sessionStorage.setItem('authorization', JSON.stringify(authorization))

                if (!this.isLoadRoutes) {
                  this.addMenu(authorization)
                  this.$router.options.routes = this.menuitems
                  this.$router.addRoutes(this.menuitems)
                  this.loadRoutes()
                }
                this.$router.push({path: '/'})
              }
            }).catch(e => {
              console.log(e)
              this.$message({
                showClose: true,
                message: '登入失败!',
                type: 'error'
              })
              this.changeVerify()
              this.logining = false
            })
          }
        })
      },
      ...mapActions([
        'addMenu',
        'loadRoutes'
      ])
    },
    mounted () {
      console.log(' ________  ________ _________   \n' +
          '|\\   __  \\|\\   ____\\\\___   ___\\ \n' +
          '\\ \\  \\|\\  \\ \\  \\___\\|___ \\  \\_| \n' +
          ' \\ \\   __  \\ \\  \\       \\ \\  \\  \n' +
          '  \\ \\  \\ \\  \\ \\  \\____   \\ \\  \\ \n' +
          '   \\ \\__\\ \\__\\ \\_______\\  \\ \\__\\\n' +
          '    \\|__|\\|__|\\|_______|   \\|__|')
      console.log('码出高效,码出质量,源码就在 https://172.31.82.149/svn/IdcSystem2/2trunk/web/cu_code/new_frameword_test/act-alone')
      this.changeVerify()
      if (this.isLoadRoutes) {
        sessionStorage.removeItem('user')
        sessionStorage.removeItem('tabSysInfo')
        sessionStorage.removeItem('authorization')
        location.replace('')
      }

      particlesJS('box',

        {
          'particles': {
            'number': {
              'value': 25,
              'density': {
                'enable': true,
                'value_area': 800
              }
            },
            'color': {
              'value': '#e5e5e5'
            },
            'shape': {
              'type': 'circle',
              'stroke': {
                'width': 0,
                'color': '#000'
              },
              'polygon': {
                'nb_sides': 5
              },
              'image': {
                'src': 'img/github.svg',
                'width': 100,
                'height': 100
              }
            },
            'opacity': {
              'value': 0.5,
              'random': false,
              'anim': {
                'enable': false,
                'speed': 1,
                'opacity_min': 0.1,
                'sync': false
              }
            },
            'size': {
              'value': 15,
              'random': true,
              'anim': {
                'enable': false,
                'speed': 5,
                'size_min': 0.1,
                'sync': false
              }
            },
            'line_linked': {
              'enable': true,
              'distance': 150,
              'color': '#ddd',
              'opacity': 0.4,
              'width': 1
            },
            'move': {
              'enable': true,
              'speed': 2,
              'direction': 'none',
              'random': false,
              'straight': false,
              'out_mode': 'out',
              'attract': {
                'enable': false,
                'rotateX': 600,
                'rotateY': 1200
              }
            }
          },
          'interactivity': {
            'detect_on': 'canvas',
            'events': {
              'onhover': {
                'enable': false,
                'mode': 'repulse'
              },
              'onclick': {
                'enable': true,
                'mode': 'push'
              },
              'resize': true
            },
            'modes': {
              'grab': {
                'distance': 400,
                'line_linked': {
                  'opacity': 1
                }
              },
              'bubble': {
                'distance': 400,
                'size': 40,
                'duration': 2,
                'opacity': 8,
                'speed': 3
              },
              'repulse': {
                'distance': 200
              },
              'push': {
                'particles_nb': 4
              },
              'remove': {
                'particles_nb': 2
              }
            }
          },
          'retina_detect': true,
          'config_demo': {
            'hide_card': false,
            'background_color': '#b61924',
            'background_image': '',
            'background_position': '50% 50%',
            'background_repeat': 'no-repeat',
            'background_size': 'cover'
          }
        }
      )
    }

  }
</script>

<style lang="scss" scoped>
</style>