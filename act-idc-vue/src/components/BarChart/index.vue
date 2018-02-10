<template>
    <div :class="className" :style="{height:height,width:width}" ref="chart"></div>
</template>

<script>
  import echarts from 'echarts'

  require('echarts/theme/vintage')
  require('echarts/theme/dark')
  require('echarts/theme/macarons')
  require('echarts/theme/infographic')
  require('echarts/theme/shine')

  export default {
    name: 'BarChart',

    props: {
      className: {
        type: String,
        default: 'chart'
      },
      width: {
        type: String,
        default: '100%'
      },
      height: {
        type: String,
        default: '280px'
      },
      // 标题
      titleText: {
        type: String,
        default: ''
      },
      // 主题
      theme: {
        type: String,
        default: ''
      },
      // 类别
      category: {
        type: Array,
        default () {
          return []
        }
      },

      // 数据
      dataList: {
        type: Array,
        default () {
          return []
        }
      }

    },
    data () {
      return {
        chart: null
      }
    },
    mounted () {
      this.initChart()
    },
    methods: {
      initChart () {
        const legendData = this.getLegendData()
        this.getListData()

        this.chart = echarts.init(this.$refs.chart, this.theme)

        this.chart.setOption({
          // 标题
          title: {
            text: this.titleText,
            textStyle: {
              fontSize: 14,
              fontWeight: 'bolder',
              color: '#333'
            }
          },
          tooltip: {
            trigger: 'axis',

            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          // 图例
          legend: {
            data: legendData
          },
          toolbox: {
            show: true,
            feature: {
              mark: {show: true},
              dataView: {show: true, readOnly: false},
              magicType: {show: true, type: ['line', 'bar']},
              restore: {show: true},
              saveAsImage: {show: true}
            }
          },
          xAxis: [
            {
              type: 'value',
              boundaryGap: [0, 0.01]
            }
          ],
          yAxis: [
            {
              type: 'category',
              axisLabel: {
                interval: 0,
                formatter (param) {
                  return param
                }
              },
              data: this.category
            }
          ],
          series: this.dataList
        })
      },

      getLegendData () {
        const legendData = []
        if (this.dataList) {
          this.dataList.forEach(item => {
            legendData.push(item.name)
          }
          )
        }
        return legendData
      },

      getListData () {
        const itemStyle = {
          normal: {
            color (params) {
              const colorList = [
                '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                '#D7504B', '#C6E579', '#F4E001'
              ]
              return colorList[params.dataIndex]
            }
          }
        }

        const label = {
          normal: {
            show: true,
            position: 'inside'
          }

        }

        this.dataList.forEach(
          item => {
            item.itemStyle = itemStyle
            item.label = label
          }
        )
      }

    }
  }
</script>
