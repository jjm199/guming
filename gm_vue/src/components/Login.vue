<template>
    <el-container>
    <div class="login-container">
        <el-form :model="loginForm" :rules="rules2"
                 status-icon
                 ref="ruleForm2"
                 label-position="left"
                 label-width="0px"
                 class="demo-ruleForm login-page">
            <h3 class="title">Gu Ming</h3>
            <el-form-item prop="username">
                <el-input type="text"
                          v-model="loginForm.username"
                          auto-complete="off"
                          placeholder="用户名"
                ></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password"
                          v-model="loginForm.password"
                          auto-complete="off"
                          placeholder="密码"
                ></el-input>
            </el-form-item>
            <el-form-item prop="code">
                <el-input class="code" prefix-icon="el-icon-chat-line-round" v-model="loginForm.code"
                          placeholder="验证码" type="primary" native-type="submit"></el-input>
                <img src="http://localhost:8888/util/getCodeImg" id="code" @click="changeCode"
                     style="float: right;margin-top: 4px;cursor: pointer" title="看不清,点击刷新"
                     alt="验证码"/>
            </el-form-item>
            <el-checkbox
                    v-model="checked"
                    class="rememberme"
            >记住密码</el-checkbox>
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
    </el-container>
</template>

<script>
    export default {
        data(){
            //自定义验证码校验规则
            var validateCode = (rule, value, callback) => {
                //验证码不区分大小写
                if (value.toString().toLocaleLowerCase() !== this.code.toString().toLocaleLowerCase()) {
                    callback(new Error('验证码输入错误'))
                } else {
                    callback()
                }
            }
            return {
                logining: false,
                //登录表单数据信息
                loginForm: {
                    username: '',
                    password: '',
                    // 验证码
                    code: ''
                },
                rules2: {
                    username: [
                        {
                            required: true,
                            message: '请输入账号',
                            trigger: 'blur'
                        },
                    ],
                    password: [
                        {
                            required: true,
                            message: '请输入密码',
                            trigger: 'blur'
                        },
                        {
                            min: 5,
                            message: '密码不能小于5个字符',
                            trigger: 'blur'
                        }
                    ],
                    code: [
                        {
                            required: true,
                            message: '请输入验证码',
                            trigger: 'blur'
                        },
                        {
                            validator: validateCode,
                            trigger: 'blur'
                        }
                    ],
                },
                checked: false,
                //后台的验证码
                code: window.onload = () => this.getCode(),
            }
        },
        mounted () {
            this.changeCode()
            // //检验用户是否存在token,存在直接跳转主页
            // this.checkToken()
        },
        methods: {

            handleSubmit(){
                this.$refs['loginForm'].validate((valid) => {
                    if(valid) {
                        this.logining = true;

                        const data = new FormData;
                        data.append('username', this.loginForm.username);
                        data.append('password', this.loginForm.password);
                        //发送登录请求
                        this.$http.post(this.API.loginByName, data).then((resp) => {
                            if (resp.data.code === 200) {
                                console.log(resp.data)
                                this.$notify({
                                    title: 'Tips',
                                    message: '登陆成功^_^',
                                    type: 'success',
                                    duration: 2000
                                })
                                this.$router.push('/index')
                            } else {
                                this.changeCode()
                                this.getCode()
                                this.$notify({
                                    title: 'Tips',
                                    message: resp.data.message,
                                    type: 'error',
                                    duration: 2000
                                })
                            }
                        })
                    } else{
                        console.log('error submit!');
                        return false;
                    }
                })
            },
            //点击图片刷新验证码
            changeCode () {
                const code = document.querySelector('#code')
                code.src = 'http://localhost:8888/util/getCodeImg?id=' + Math.random()
                code.onload = () => this.getCode()
            },
            //获取后台验证码
            getCode () {
                this.$http.get(this.API.getCode).then((resp) => {
                    this.code = resp.data.message
                })
            },
        }
    };
</script>

<style scoped>
    .el-container {
        width: 100%;
        height: 100%;
        background: url("../assets/img/login_bg2.jpg");
    }
    .login-container {
        width: 100%;
        height: 100%;
    }
    .login-page {
        -webkit-border-radius: 5px;
        border-radius: 10px;
        margin: 200px auto;
        align-content: center;
        width: 350px;
        padding: 35px 35px 19px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    .title {
        text-align: center;
        margin-bottom: 10px;
    }
    label.el-checkbox.rememberme {
        margin: 0px 0px 15px;
        text-align: left;
    }
</style>