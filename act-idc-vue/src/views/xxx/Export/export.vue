<template>
    <section>

        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form>
                <el-form-item>
                    <el-button type="primary" size="small" v-on:click="exportExcel"><i
                            class="fa fa-search fa-lg"></i> 导出样例
                    </el-button>
                </el-form-item>
            </el-form>
        </el-col>
    </section>
</template>


<script>
  import {exportExcelByExportUtil} from '../../../js/excelUtil'
  import {exportExcel} from './export.api'

  export default {
    methods: {
      exportExcel () {
        exportExcel().then(res => {
          if (res.error) {
            this.$message({
              showClose: true,
              message: res.error,
              type: 'error'
            })
          } else {
            exportExcelByExportUtil(res.success)
          }
        })
      }
    }
  }
</script>