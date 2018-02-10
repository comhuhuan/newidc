<template>
    <section>


        <el-form :model="sysForm" ref="sysForm" label-position="right" label-width="270px" label-suffix=":">


            <el-row  v-for="(item,index) in sysForm.sysList" :key="index">

                <!--输入框 showtype= '0' -->
                <el-form-item :prop="'sysList.' + index + '.configval'" :label="item.title"
                              :rules=saveFormRules.configval v-if="item.showtype == '0'">
                    <el-input v-model="item.configval" size="small" :placeholder="item.defaultval">
                    </el-input>
                </el-form-item>

                <!--开关 showtype= '2' -->
                <el-form-item :prop="'sysList.' + index + '.configval'" :label="item.title"
                              :rules=saveFormRules.configval v-if="item.showtype == '2'">
                    <el-switch v-model="item.configval" on-text="开启" on-value="Y" off-text="关闭"
                               off-value="N"></el-switch>
                </el-form-item>

                <!--下拉框-->
                <el-form-item :prop="'sysList.' + index + '.configval'" :label="item.title"
                              :rules=saveFormRules.configval v-if="item.showtype == '1'">


                    <el-select v-model="item.configval" filterable clearable
                               placeholder="请选择">
                        <el-option v-for="(item,index) in getOptions(item)" :label="item.label" :key="index"
                                   :value="item.value">
                        </el-option>
                    </el-select>

                </el-form-item>


                <el-form-item v-if="(sysForm.groupCount).indexOf(index+1) != -1">
                </el-form-item>


            </el-row>

        </el-form>

        <div slot="footer" class="dialog-footer">
            <el-button size="small" type="success" @click.native="resetSubmit" :loading="resetLoading" plain><i
                    class="fa fa-reply fa-lg"></i> 还原


            </el-button>
            <el-button size="small" type="primary" @click.native="updateSubmit" :loading="updateLoading" plain><i
                    class="fa fa-cog fa-lg"></i> 提交


            </el-button>
        </div>

    </section>
</template>


<script>
  import {initialize, resetConfig, updateConfig} from './sysConfig.api'
  export default {
    data () {
      return {
        sysForm: {
          // 配置信息
          sysList: [],
          groupCount: []
        },
        addForm: {
          // 配置信息
          sysList: []
        },
        resetLoading: false,
        updateLoading: false,

        // 保存规则
        saveFormRules: {
          configval: [
            {required: true, message: '请输入参数', trigger: 'blur'}
          ]
        },

        selectOptions: [
          {'value': '0', 'label': '下拉1'},
          {'value': '1', 'label': '下拉2'}]

      }
    },
    methods: {

      initAddForm: function () {
        let temp = []
        this.sysForm.sysList.forEach(
          function (item) {
            temp.push(JSON.stringify(item))
          }
        )
        this.addForm.sysList = temp
        if (this.sysForm.sysList.length === 1) {
          this.addForm.sysList.push('')
        }
      },

      /** ****************************************下拉框初始化开始************************************************************/
      getOptions (item) {
        if (item.configid === 'sys_select') {
          return this.selectOptions
        }
      },

      /** ****************************************拉框初始化结束**************************************************************/

      /** ****************************************初始化开始************************************************************/
      initialize () {
        initialize().then((res) => {
          if (res.error) {
            this.$message({
              showClose: true,
              message: res.error,
              type: 'error'
            })
          } else {
            this.sysForm.sysList = res.success.sysConfigList
            this.sysForm.groupCount = this.loadGroup(res.success.groupCount)
          }
          this.listLoading = false
        })
      },

      // 重载每类配置的统计数 20170920
      loadGroup (groupCount) {
        const loadGroup = []
        if (groupCount) {
          groupCount.forEach(
            (item, index) => {
              if (index === 0) {
                loadGroup[index] = item
              } else {
                loadGroup[index] = item + loadGroup[index - 1]
              }
            }
          )
        }
        return loadGroup
      },

      /** ****************************************初始化结束************************************************************/

      /** ****************************************还原开始**************************************************************/
      resetSubmit: function () {
        this.$confirm('确认还原配置吗？', '提示', {}).then(() => {
          this.resetLoading = true
          resetConfig().then((res) => {
            this.resetLoading = false
            if (res.error) {
              this.$message({
                showClose: true,
                message: res.error,
                type: 'error'
              })
            } else {
              this.$message({
                showClose: true,
                message: '还原配置成功',
                type: 'success'
              })
            }
            this.initialize()
          })
        })
      },
      /** ****************************************还原结束**************************************************************/

      /** ****************************************更新开始**************************************************************/
      updateSubmit: function () {
        this.$refs.sysForm.validate((valid) => {
          if (valid) {
            this.$confirm('确认更新配置吗？', '提示', {}).then(() => {
              this.initAddForm()
              this.updateLoading = true
              updateConfig(this.addForm).then((res) => {
                this.updateLoading = false
                if (res.error) {
                  this.$message({
                    showClose: true,
                    message: res.error,
                    type: 'error'
                  })
                } else {
                  this.$message({
                    showClose: true,
                    message: '更新配置成功',
                    type: 'success'
                  })
                  this.$refs['sysForm'].resetFields()
                }
                this.initialize()
              })
            })
          } else {
            this.$message({
              showClose: true,
              message: '请完成必填信息,且格式正确!',
              type: 'error'
            })
          }
        })
      }
      /** ****************************************更新结束**************************************************************/

    },

    created () {
      this.initialize()
    }
  }
</script>
