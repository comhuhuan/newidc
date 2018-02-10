<template>
    <section class="first_bj_png">
        <el-carousel :height="firstHeight" v-loading="loading" element-loading-text="拼命加载中"
                     indicator-position trigger="click" :autoplay=false @change="changeCarousel">
            <el-carousel-item label="样例1">
                <div style="margin-top: 15px;" :v-show="testView">
                    <el-row :gutter="20">

                        <el-col :span="6">
                            <el-card class="el-card-my">
                                <div slot="header">
                                    <span style="line-height: 14px;font-weight:bold;font-size: 16px">饼状图样例</span>
                                </div>

                                <pie-chart v-if="testView" :titleText="pieTest.titleText"
                                           :seriesName="pieTest.seriesName"
                                           :theme="pieTest.theme" :dataList="pieTest.dataList"></pie-chart>

                                <pie-chart v-if="testView" :titleText="pieTest.titleText"
                                           :seriesName="pieTest.seriesName"
                                           :theme="pieTest.theme" :dataList="pieTest.dataList"></pie-chart>

                                <pie-chart v-if="testView" :titleText="pieTest.titleText"
                                           :seriesName="pieTest.seriesName"
                                           :theme="pieTest.theme" :dataList="pieTest.dataList"></pie-chart>

                            </el-card>
                        </el-col>


                        <el-col :span="18">

                            <el-row :gutter="20">
                                <el-card class="el-card-my">
                                    <div slot="header">
                                        <span style="line-height: 14px;font-weight:bold;font-size: 16px">横向柱状图样例</span>
                                    </div>

                                    <bar-chart v-if="testView" :titleText="barTest.titleText"
                                               :category="barTest.category"
                                               :theme="barTest.theme" :dataList="barTest.dataList"></bar-chart>

                                </el-card>
                            </el-row>


                            <el-row :gutter="20" style="margin-top:5px;">
                                <el-card class="el-card-my">
                                    <div slot="header">
                                        <span style="line-height: 14px;font-weight:bold;font-size: 16px">竖向柱状图样例</span>
                                    </div>

                                    <trend-chart v-if="testView" :titleText="trendTest.titleText"
                                                 :category="trendTest.category"
                                                 :theme="trendTest.theme"
                                                 :dataList="trendTest.dataList"></trend-chart>
                                </el-card>
                            </el-row>

                        </el-col>


                    </el-row>
                </div>
            </el-carousel-item>

            <el-carousel-item label="样例2">
                <div style="margin-top: 15px;" :v-show="testView">
                    <el-row :gutter="20">

                        <el-col :span="6">
                            <el-card class="el-card-my">
                                <div slot="header">
                                    <span style="line-height: 14px;font-weight:bold;font-size: 16px">饼状图样例</span>
                                </div>

                                <pie-chart v-if="testView" :titleText="pieTest.titleText"
                                           :seriesName="pieTest.seriesName"
                                           :theme="pieTest.theme" :dataList="pieTest.dataList"></pie-chart>

                                <pie-chart v-if="testView" :titleText="pieTest.titleText"
                                           :seriesName="pieTest.seriesName"
                                           :theme="pieTest.theme" :dataList="pieTest.dataList"></pie-chart>

                                <pie-chart v-if="testView" :titleText="pieTest.titleText"
                                           :seriesName="pieTest.seriesName"
                                           :theme="pieTest.theme" :dataList="pieTest.dataList"></pie-chart>

                            </el-card>
                        </el-col>


                        <el-col :span="18">

                            <el-row :gutter="20">
                                <el-card class="el-card-my">
                                    <div slot="header">
                                        <span style="line-height: 14px;font-weight:bold;font-size: 16px">横向柱状图样例</span>
                                    </div>

                                    <bar-chart v-if="testView" :titleText="barTest.titleText"
                                               :category="barTest.category"
                                               :theme="barTest.theme" :dataList="barTest.dataList"></bar-chart>

                                </el-card>
                            </el-row>


                            <el-row :gutter="20" style="margin-top:5px;">
                                <el-card class="el-card-my">
                                    <div slot="header">
                                        <span style="line-height: 14px;font-weight:bold;font-size: 16px">竖向柱状图样例</span>
                                    </div>

                                    <trend-chart v-if="testView" :titleText="trendTest.titleText"
                                                 :category="trendTest.category"
                                                 :theme="trendTest.theme"
                                                 :dataList="trendTest.dataList"></trend-chart>
                                </el-card>
                            </el-row>

                        </el-col>


                    </el-row>
                </div>
            </el-carousel-item>
        </el-carousel>

    </section>
</template>

<script>
  import PieChart from 'components/PieChart'
  import BarChart from 'components/BarChart'
  import TrendChart from 'components/TrendChart'
  import { init } from './first.api'

  export default {
    name: 'first',
    components: {PieChart, BarChart, TrendChart},
    data () {
      return {
        testView: false,
        loading: false,
        firstHeight: '800px',
        pieTest: {},
        barTest: {},
        trendTest: {}
      }
    },

    methods: {
      /** ************************************初始化开始**********************************************************/
      init: function () {
        this.loading = true
        init().then((res) => {
          this.loading = false
          if (res.error) {
            this.$message({
              showClose: true,
              message: res.error,
              type: 'error'
            })
          } else {
            this.pieTest = res.success.pieTest
            this.barTest = res.success.barTest
            this.trendTest = res.success.trendTest
          }
          this.testView = true
        }
        )
      },
      /** ************************************初始化结束**********************************************************/

      changeCarousel: function (index) {
        this.firstHeight = '800px'
      }

    },

    created () {
      this.init()
    }

  }
</script>


<style>
    .first_bj_png {
        background: url(../../../image/first/first_bj.jpg) no-repeat bottom right;
        height: 98%;
        width: 100%;
    }

    .el-card-my {
        background-color: transparent;
    }
</style>

