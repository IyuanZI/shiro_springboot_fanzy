<template>
  <h1>{{ msg }}</h1>
  <el-form :model="messageBox" :rules="baseRules">
    <el-form-item prop="phoneNum">
      <el-input v-model="messageBox.phoneNum" placeholder="请输入您的账号"/>
    </el-form-item>
    <el-form-item prop="code">
      <el-input v-model="messageBox.code" placeholder="请输入您的密码">
      </el-input>
    </el-form-item>
  </el-form>
  <el-button class="btnLogin" type="primary" @click="login">登录</el-button>


  <div class="bottom">
    <div class="autoLogin">
      <el-radio-group v-model="autoLogin" class="el-radio">
        <el-radio label="1" size="large" @change="ifAuto">下次自动登录</el-radio>
      </el-radio-group>
    </div>
    <div class="forget">
      <el-link type="info">忘记密码？</el-link>
    </div>
  </div>
</template>


<script lang="ts" setup>
import {ElMessage, ElMessageBox} from "element-plus";
import {Action} from "element-plus";
import {ref} from "vue";

defineProps<{ msg: string }>()

const messageBox = ref({
  phoneNum: ref(''),
  code: ref('')
})
// 登录请求
const login = function () {
  console.log("login")
}
/* 表单验证 */
const baseRules = ref({
  phoneNum: [
    {
      required: true,
      message: '请输入手机号码',
      trigger: 'change'
    },
    {
      min: 11,
      max: 11,
      message: '请输入11位手机号码',
      trigger: 'change'
    },
    {
      pattern: /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/,
      message: '请输入正确的手机号码'
    }
  ],
  code: [
    {
      required: true,
      message: '请输入验证码',
      trigger: 'change'
    },
    {
      min: 6,
      max: 6,
      message: '请输入完整验证码',
      trigger: 'change'
    }
  ]
});

let autoLogin = ref('0')
const ifAuto = function () {
  console.log("11111");
}
</script>

<style scoped>
div {
  /*border: 1px red solid;*/
}

.btnLogin {
  width: 100%;
}

.autoLogin {
  float: left;
  height: 100%;

}

.forget {
  float: right;
  font-size: 30px;
}
</style>