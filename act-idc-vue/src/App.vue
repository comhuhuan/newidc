<!--
template,
这个就是第二层 layout， 可以看到， 里面还有个 div id = 'app'
这个元素跟 index.html中的是同一个元素（暂且这么理解）
所有的 <router-view>中的内容，都会被自动替换。
<script>中的代码则是脚本代码。 至此，整个过程就出来了。
-->

<template>
    <!--即index.html-->
    <div id="app">
        <transition name="fade"
                    mode="out-in">
            <!--内容，都会被自动替换-->
            <router-view></router-view>
        </transition>
    </div>
</template>


<script>
    // 定义组件
    export default {
      name: 'app',
      components: {}
    }
</script>

<style lang="scss">
    body {
        margin: 0px;
        padding: 0px;
        /*background: url(assets/bg1.jpg) center !important;
            background-size: cover;*/
    // background: #1F2D3D;
        font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB, Microsoft YaHei, SimSun, sans-serif;
        font-size: 12px;
        -webkit-font-smoothing: antialiased;
    }

    #app {
        position: absolute;
        top: 0px;
        bottom: 0px;
        width: 100%;
    }

    .el-submenu [class^=fa] {
        vertical-align: baseline;
        margin-right: 10px;
    }

    .el-menu-item [class^=fa] {
        vertical-align: baseline;
        margin-right: 10px;
    }

    .toolbar {
        background: #f2f2f2;
        padding: 10px;
    //border:1px solid #dfe6ec;
        margin: 10px 0px;
    .el-form-item {
        margin-bottom: 10px;
    }
    }

    .fade-enter-active,
    .fade-leave-active {
        transition: all .2s ease;
    }

    .fade-enter,
    .fade-leave-active {
        opacity: 0;
    }
</style>