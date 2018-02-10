<template>
    <section>

        <!-----------------------------------------高级查询界面开始------------------------------------------------------->
        <transition name="el-zoom-in-bottom">
            <el-col :span="24" class="toolbar" v-show="seniorVisible" style="padding-bottom: 0px;">

                <el-form label-width="120px" :model="filters" ref="seniorFilters">

                    <el-row>
                        <el-col :span="6">
                            <el-form-item label="查询sql" prop = "sqlSentenceQuery">
                                <el-input v-model="filters.sqlSentenceQuery" placeholder="查询sql模糊查询"></el-input>
                            </el-form-item>
                        </el-col>

                        <el-col :span="6">
                            <el-form-item label="核查类型" prop = "remarkQuery">
                                <el-input v-model="filters.remarkQuery" placeholder="核查类型模糊查询"></el-input>
                            </el-form-item>
                        </el-col>

                        <el-col :span="6">
                            <el-form-item label="创建者" prop = "creatorQuery">
                                <el-input v-model="filters.creatorQuery" placeholder="创建者模糊查询"></el-input>
                            </el-form-item>
                        </el-col>

                        <el-col :span="6">
                            <el-form-item label="修改者" prop = "modifierQuery">
                                <el-input v-model="filters.modifierQuery" placeholder="修改者模糊查询"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>


                    <el-row>
                        <el-col :span="24">
                            <el-form-item label="创建时间" prop = "createDateRange">
                                <el-date-picker v-model="createDateRange" type="datetimerange" placeholder="请选择日期时间"
                                                :editable="false">
                                </el-date-picker>
                            </el-form-item>
                        </el-col>
                    </el-row>


                    <el-row>
                        <el-col :span="24">
                            <el-form-item label="修改时间" prop = "updateDateRange">
                                <el-date-picker v-model="updateDateRange" type="datetimerange" placeholder="请选择日期时间"
                                                :editable="false">
                                </el-date-picker>
                            </el-form-item>
                        </el-col>
                    </el-row>

                </el-form>
            </el-col>
        </transition>
        <!-----------------------------------------高级查询界面结束------------------------------------------------------->


        <!----------------------------------------------工具条开始------------------------------------------------------->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">

            <el-form :inline="true" :model="filters" ref="filters">
                <el-form-item label="核查类型" prop="remarkQuery">
                    <el-input v-model="filters.remarkQuery" placeholder="核查类型模糊查询"></el-input>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" v-on:click="pagingList"  size="small" plain><i
                            class="fa fa-search fa-lg"></i> 查询
                    </el-button>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" v-on:click="handleSenior" size="small" plain><i
                            :class="searchClass"></i> 高级
                    </el-button>
                </el-form-item>

                <el-form-item>
                    <el-button type="success" v-on:click="handleReset()"
                               size="small" plain><i class="fa fa-refresh fa-lg"></i> 重置
                    </el-button>
                </el-form-item>

            </el-form>


            <el-form :inline="true">
                <el-form-item>
                    <el-button type="success" v-on:click="handleAdd" icon="el-icon-plus"  title="新增" size="small" plain>
                        新增
                    </el-button>
                </el-form-item>
            </el-form>

        </el-col>
        <!----------------------------------------------工具条结束------------------------------------------------------->


        <!----------------------------------------------增删改查样例查询列表开始---------------------------------------------->
        <el-table :data="dataList" :height="tableHigth" v-loading="listLoading" @selection-change="selsChange"
                  highlight-current-row stripe border resizable>
            <el-table-column type="selection"></el-table-column>
            <el-table-column type="index" label="序号" width="80"></el-table-column>
            <el-table-column prop="sqlSentence" show-overflow-tooltip label="查询sql" label-class-name="el-tooltip">
            </el-table-column>
            <el-table-column prop="remark" show-overflow-tooltip label="核查类型" label-class-name="el-tooltip">
            </el-table-column>
            <el-table-column prop="plan" show-overflow-tooltip label="处理建议" label-class-name="el-tooltip">
            </el-table-column>
            <el-table-column prop="creator" show-overflow-tooltip label="创建者" label-class-name="el-tooltip">
            </el-table-column>
            <el-table-column prop="modifier" show-overflow-tooltip label="修改者" label-class-name="el-tooltip">
            </el-table-column>
            <el-table-column prop="createDate" show-overflow-tooltip label="创建时间" :formatter="formatCreateDate"
                             label-class-name="el-tooltip">
            </el-table-column>
            <el-table-column prop="updateDate" show-overflow-tooltip label="修改时间" :formatter="formatUpdateDate"
                             label-class-name="el-tooltip">
            </el-table-column>
            <el-table-column label="操作" width="180" header-align="center" align="center">
                <template slot-scope="scope">
                    <el-button-group>
                        <el-button type="primary" @click="handleEdit(scope.$index, scope.row)" icon="el-icon-edit" title="编辑" size="mini"></el-button>
                        <el-button type="danger" @click="handleDel(scope.$index, scope.row)" icon="el-icon-delete" title="删除" size="mini"></el-button>
                        <el-button type="success" @click="handleView(scope.$index, scope.row)" title="详情" size="mini"><i class="fa fa-info-circle fa-lg"></i></el-button>
                    </el-button-group>
                </template>
            </el-table-column>
        </el-table>
        <!----------------------------------------------增删改查样例查询列表结束---------------------------------------------->


        <!------------------------------------------------分页器开始----------------------------------------------------->
        <el-col :span="24" class="toolbar">
            <el-button type="danger" @click="batchRemove" :disabled="this.sels.length===0">批量删除



            </el-button>
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :page-sizes="[10,15,25,50,100]"
                    :page-size=filters.pageSize
                    :current-page.sync="resetIndex"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total"
                    style="float:right;">
            </el-pagination>
        </el-col>
        <!------------------------------------------------分页器结束----------------------------------------------------->


        <!-----------------------------------------------新增界面开始---------------------------------------------------->
        <el-dialog title="新增" :visible.sync="addFormVisible" :close-on-click-modal="false" size="large">
            <el-form :model="addForm" ref="addForm" label-width="120px" :rules="addFormRules">
                <el-form-item label="核查类型" prop="remark">
                    <el-input v-model="addForm.remark" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="查询sql" prop="sqlSentence">
                    <el-input v-model="addForm.sqlSentence" type="textarea" :rows="5" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="处理建议" prop="plan">
                    <el-input v-model="addForm.plan" type="textarea" :rows="5" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer">
                <el-button @click.native="addFormVisible = false;">取消</el-button>
                <el-button type="primary" @click.native="addSubmit" :loading="addLoading">提交</el-button>
            </div>
        </el-dialog>
        <!-----------------------------------------------新增界面结束---------------------------------------------------->


        <!-----------------------------------------------编辑界面开始---------------------------------------------------->
        <el-dialog title="编辑":visible.sync="editFormVisible" :close-on-click-modal="false" size="large">
            <el-form :model="editForm" ref="editForm" label-width="120px" :rules="editFormRules">
                <el-form-item label="核查类型" prop="remark">
                    <el-input v-model="editForm.remark" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="查询sql" prop="sqlSentence">
                    <el-input v-model="editForm.sqlSentence" type="textarea" :rows="5" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="处理建议" prop="plan">
                    <el-input v-model="editForm.plan" type="textarea" :rows="5" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="editFormVisible = false">取消</el-button>
                <el-button type="primary" @click.native="editSubmit" :loading="editLoading">提交</el-button>
            </div>
        </el-dialog>
        <!-----------------------------------------------编辑界面结束---------------------------------------------------->


        <!-----------------------------------------------详情界面开始---------------------------------------------------->
        <el-dialog title="详情" :visible.sync="viewFormVisible" :close-on-click-modal="false" class="view-table" size="large">
            <el-tabs type="border-card">
                <el-tab-pane label="增删改查样例"></el-tab-pane>
                <el-form label-position="right" label-width="80px" label-suffix = ":">
                    <el-row>
                        <el-col :span="24">
                            <el-form-item label="核查类型">
                                <span>{{viewForm.remark}}</span>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="24">
                            <el-form-item label="处理建议">
                                <span>{{viewForm.plan}}</span>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="24">
                            <el-form-item label="SQL语句">
                                <span>{{viewForm.sqlSentence}}</span>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="创建者">
                                <span>{{viewForm.creator}}</span>
                            </el-form-item>
                        </el-col>

                        <el-col :span="12">
                            <el-form-item label="修改者">
                                <span>{{viewForm.modifier}}</span>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12">
                            <el-form-item label="创建时间">
                                <span>{{viewForm.createDate}}</span>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="修改时间">
                                <span>{{viewForm.updateDate}}</span>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
            </el-tabs>

            <div slot="footer" class="dialog-footer">
                <el-button @click.native="viewFormVisible = false">返回</el-button>
            </div>

        </el-dialog>
        <!-----------------------------------------------详情界面结束---------------------------------------------------->


    </section>
</template>


<script>
    import tableHeight from '../../../js/heightUtil'
    import dateUtil from '../../../js/dateUtil'
    import {pagingList, save, remove} from './crudSample.api'
    export default {
      data () {
        return {
          dataList: [], // 增删改查样例查询列表
          listLoading: false, // 加载查询list
          tableHigth: '', // 列表高度
          sels: [], // 列表选中列
          total: 0, // 总数
          searchClass: 'fa fa-chevron-down fa-lg', // 查询样式class
          createDateRange: '', // 查询创建时间段
          updateDateRange: '', // 查询修改时间段
          resetIndex: 1, // 初始化显示页
          // 查询条件
          filters: {
            pageIndex: 0,
            pageSize: 15,
            sqlSentenceQuery: '',
            remarkQuery: '',
            createDateQuery: '',
            updateDateQuery: '',
            creatorQuery: '',
            modifierQuery: ''
          },
          // 高级查询
          seniorVisible: false,

          // 新增
          addFormVisible: false,
          addLoading: false,
          addForm: {
            commonFlag: 'add',
            sqlSentence: '',
            plan: '',
            remark: '',
            creator: '',
            modifier: ''
          },
          addFormRules: {
            sqlSentence: [
              {required: true, message: '请输入查询SQL', trigger: 'blur'},
              {validator: this.validateSql, trigger: 'blur'}
            ],
            remark: [
              {required: true, message: '请输入核查类型', trigger: 'blur'}
            ],
            plan: [
              {required: true, message: '请输入处理建议', trigger: 'blur'}
            ]
          },

          // 编辑
          editLoading: false,
          editFormVisible: false,
          editForm: {
            commonFlag: 'edit',
            engineId: '',
            sqlSentence: '',
            plan: '',
            remark: '',
            modifier: ''
          },
          editFormRules: {
            sqlSentence: [
              {required: true, message: '请输入查询SQL', trigger: 'blur'},
              {validator: this.validateSql, trigger: 'blur'}
            ],
            remark: [
              {required: true, message: '请输入核查类型', trigger: 'blur'}
            ],
            plan: [
              {required: true, message: '请输入处理建议', trigger: 'blur'}
            ]
          },

          // 详情
          viewFormVisible: false,
          viewForm: {
            sqlSentence: '',
            remark: '',
            createDate: '',
            updateDate: '',
            creator: '',
            modifier: '',
            plan: ''
          },
          // 导出
          exportDis: false

        }
      },

      methods: {
        // 检验sql语句正确性 不能包含 ;
        validateSql: (rule, value, callback) => {
          if (value.indexOf(';') !== -1) {
            callback(new Error('包含非法字符 ‘;’ '))
          } else {
            callback()
          }
        },

        // 格式化时间
        formatCreateDate: function (row, column) {
          return (!row.createDate || row.createDate === '') ? '' : dateUtil.formatDate.format(new Date(row.createDate), 'yyyy-MM-dd hh:mm:ss')
        },
        formatUpdateDate: function (row, column) {
          return (!row.updateDate || row.updateDate === '') ? '' : dateUtil.formatDate.format(new Date(row.updateDate), 'yyyy-MM-dd hh:mm:ss')
        },

        /** ************************************查询分页开始**********************************************************/
        // 分页查询
        pagingList: function () {
          if (this.createDateRange[0]) {
            this.filters.createDateQuery = [dateUtil.formatDate.format(this.createDateRange[0], 'yyyy-MM-dd hh:mm:ss'), dateUtil.formatDate.format(this.createDateRange[1], 'yyyy-MM-dd hh:mm:ss')]
          } else {
            this.filters.createDateQuery = ''
          }
          if (this.updateDateRange[0]) {
            this.filters.updateDateQuery = [dateUtil.formatDate.format(this.updateDateRange[0], 'yyyy-MM-dd hh:mm:ss'), dateUtil.formatDate.format(this.updateDateRange[1], 'yyyy-MM-dd hh:mm:ss')]
          } else {
            this.filters.updateDateRange = ''
          }
          this.listLoading = true
          this.tableHigth = tableHeight(371)
          pagingList(this.filters).then((res) => {
            if (res.error) {
              this.$message({
                showClose: true,
                message: res.error,
                type: 'error'
              })
            } else {
              this.total = res.success.total
              this.dataList = res.success.rows
            }
            this.listLoading = false
          })
        },
        // 还原查询条件
        handleReset () {
          this.$refs['filters'].resetFields()
          this.$refs['seniorFilters'].resetFields()
          this.filters.pageIndex = 0
          this.filters.pageSize = 15
          this.resetIndex = 1
          this.filters.createDateQuery = ''
          this.filters.updateDateQuery = ''
          this.createDateRange = '' // 还原创建时间段
          this.updateDateRange = '' // 还原修改时间段
          this.pagingList()
        },
        // 改变每页列数
        handleSizeChange (val) {
          this.filters.pageSize = val
          this.handleCurrentChange(1)
        },
        // 分页器属性变化后 查询
        handleCurrentChange (val) {
          if (val === 1) {
            this.filters.pageIndex = 0
          } else {
            this.filters.pageIndex = (val - 1) * (this.filters.pageSize)
          }
          this.pagingList()
        },
        // 高级查询图标变换
        handleSenior: function () {
          this.seniorVisible = !this.seniorVisible
          if (this.seniorVisible) {
            this.searchClass = 'fa fa-chevron-up fa-lg'
          } else {
            this.searchClass = 'fa fa-chevron-down fa-lg'
          }
        },
        /** *************************************查询分页结束*********************************************************/

        /** *************************************查看详情开始*********************************************************/
        handleView: function (index, row) {
          this.viewFormVisible = true
          this.viewForm.sqlSentence = row.sqlSentence
          this.viewForm.remark = row.remark
          this.viewForm.createDate = this.formatCreateDate(row)
          this.viewForm.updateDate = this.formatUpdateDate(row)
          this.viewForm.creator = row.creator
          this.viewForm.modifier = row.modifier
          this.viewForm.plan = row.plan
        },

        /** *************************************查看详情结束*********************************************************/

        /** *************************************新增开始*************************************************************/
        handleAdd: function () {
          if (this.$refs['addForm']) {
            this.$refs['addForm'].resetFields()
          }
          this.addFormVisible = true
        },
        // 新增
        addSubmit: function () {
          const currentUser = JSON.parse(sessionStorage.getItem('user'))
          this.addForm.creator = currentUser.userId
          this.addForm.modifier = currentUser.userId
          this.$refs.addForm.validate((valid) => {
            if (valid) {
              this.$confirm('确认提交吗？', '提示', {}).then(() => {
                this.addLoading = true
                save(this.addForm).then((res) => {
                  this.addLoading = false
                  if (res.error) {
                    this.$message({
                      showClose: true,
                      message: res.error,
                      type: 'error'
                    })
                  } else {
                    if (res.success === 'errSql') {
                      this.$message({
                        showClose: true,
                        message: '新增失败,请检查sql语句合法性',
                        type: 'error'
                      })
                    } else {
                      this.$message({
                        showClose: true,
                        message: '新增成功',
                        type: 'success'
                      })
                      this.addFormVisible = false
                      this.$refs['addForm'].resetFields()
                    }
                  }
                  this.pagingList()
                })
              })
            }
          })
        },
        /** *************************************新增结束*************************************************************/

        /** *************************************编辑开始*************************************************************/
        handleEdit: function (index, row) {
          this.editFormVisible = true
          this.editForm.engineId = (row.engineId)
          this.editForm.sqlSentence = (row.sqlSentence)
          this.editForm.plan = (row.plan)
          this.editForm.remark = (row.remark)
        },
        // 编辑
        editSubmit: function () {
          const currentUser = JSON.parse(sessionStorage.getItem('user'))
          this.editForm.modifier = currentUser.userId
          this.$refs.editForm.validate((valid) => {
            if (valid) {
              this.$confirm('确认提交吗？', '提示', {}).then(() => {
                this.editLoading = true
                save(this.editForm).then((res) => {
                  this.editLoading = false
                  if (res.error) {
                    this.$message({
                      showClose: true,
                      message: res.error,
                      type: 'error'
                    })
                  } else {
                    if (res.success === 'errSql') {
                      this.$message({
                        showClose: true,
                        message: '编辑失败,请检查sql语句合法性',
                        type: 'error'
                      })
                    } else {
                      this.$message({
                        showClose: true,
                        message: '编辑成功',
                        type: 'success'
                      })
                      this.editFormVisible = false
                      this.$refs['editForm'].resetFields()
                    }
                  }
                  this.pagingList()
                })
              })
            }
          })
        },
        /** *************************************编辑结束*************************************************************/

        /** *************************************删除开始*************************************************************/
        // 点击勾选框
        selsChange: function (sels) {
          this.sels = sels
        },
        handleDel: function (index, row) {
          this.$confirm('确认删除该记录吗?', '提示', {
            type: 'warning'
          }).then(() => {
            let para = {deleteIds: row.engineId}
            remove(para).then((res) => {
              if (res.error) {
                this.$message({
                  showClose: true,
                  message: res.error,
                  type: 'error'
                })
              } else {
                this.$message({
                  showClose: true,
                  message: '删除成功',
                  type: 'success'
                })
              }
              this.pagingList()
            })
          })
        },
        batchRemove: function () {
          const ids = this.sels.map(item => item.engineId).toString()
          this.$confirm('确认删除选中记录吗？', '提示', {
            type: 'warning'
          }).then(() => {
            let para = {deleteIds: ids}
            remove(para).then((res) => {
              if (res.error) {
                this.$message({
                  showClose: true,
                  message: res.error,
                  type: 'error'
                })
              } else {
                this.$message({
                  showClose: true,
                  message: '删除成功',
                  type: 'success'
                })
              }

              this.pagingList()
            })
          })
        }
        /** ************************************删除结束**************************************************************/
      },
      created () {
        this.pagingList()
      }
    }
</script>

<style>
    .view-table label {
        color: #99a9bf;
    }

</style>