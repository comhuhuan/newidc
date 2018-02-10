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
    name: 'PieChart',

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
        default: '219px'
      },
      // 标题
      titleText: {
        type: String,
        default: ''
      },
      // 副标题
      subText: {
        type: String,
        default: ''
      },
      // 鼠标显示title
      seriesName: {
        type: String,
        default: ''
      },
      // 主题
      theme: {
        type: String,
        default: ''
      },
      // 数据
      dataList: {
        type: Array,
        default () {
          return []
        }
      },
      // 图标颜色
      color: {
        type: Array,
        default () {
          return [
            '#C1232B', '#58B7FF', '#FCCE10', '#E87C25', '#27727B',
            '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
            '#D7504B', '#C6E579', '#F4E001'
          ]
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
    beforeDestroy () {
      if (!this.chart) {
        return
      }
      this.chart.dispose()
      this.chart = null
    },
    methods: {

      initChart () {
        // 图例
        const legendData = this.getLegendData()

        this.chart = echarts.init(this.$refs.chart, this.theme)

        this.chart.setOption({
          color: this.color,
          // 标题
          title: {
            text: this.titleText,
            textStyle: {
              fontSize: 14,
              fontWeight: 'bolder',
              color: '#333'
            },
            subtext: this.subText,
            x: 'center'
          },
          // 提示类型
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
          },
          // 图例
          legend: {
            orient: 'vertical',
            x: 'left',
            data: legendData
          },
          calculable: true,
          series: [
            {
              name: this.seriesName,
              // 定义饼状图
              type: 'pie',
              radius: ['50%', '70%'],
              avoidLabelOverlap: false,
              label: {
                normal: {
                  show: false,
                  position: 'center'
                },
                emphasis: {
                  show: true,
                  textStyle: {
                    fontSize: '30',
                    fontWeight: 'bold'
                  }
                }
              },
              // TODO 颜色未确立
              //                            color : ['#ff272c','#22fa4b'],
              labelLine: {
                normal: {
                  show: false
                }
              },
              data: this.dataList

            }
          ]
        })

      //                let timeTicket = null;
      //                let count=0;
      //                timeTicket = setInterval(function() {
      //                    chart.dispatchAction({
      //                        type: 'downplay',
      //                        seriesIndex: 0,
      //                    });
      //                    chart.dispatchAction({
      //                        type: 'highlight',
      //                        seriesIndex: 0,
      //                        dataIndex: count % 6
      //                    });
      //                    chart.dispatchAction({
      //                        type: 'showTip',
      //                        seriesIndex: 0,
      //                        dataIndex: count % 6,
      //                    });
      //                    count++;
      //                }, 2000);
      },

      getLegendData () {
        const legendData = []
        this.dataList.forEach(
          item => {
            legendData.push(item.name)
          }
        )
        return legendData
      }
    }
  }
</script>
