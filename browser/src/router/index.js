import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV) //生产环境就是_import_production 即是 import('@/views/' + file + '.vue')
// in development-env not use lazy-loading, because lazy-loading too many pages will cause webpack hot update too slow. so only in production use lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading
// 模块化工程中必须要通过 Vue.use() 明确地安装路由功能
Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/** note: submenu only apppear when children.length>=1
*   detail see  https://panjiachen.github.io/vue-element-admin-site/#/router-and-nav?id=sidebar
**/

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirct in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    roles: ['admin','editor']     will control the page roles (you can set multiple roles)
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
    noCache: true                if true ,the page will no be cached(default is false)
  }
**/
export const constantRouterMap = [
  { path: '/login', component: _import('login/index'), hidden: true },
  { path: '/authredirect', component: _import('login/authredirect'), hidden: true },
  { path: '/404', component: _import('errorPage/404'), hidden: true },
  { path: '/401', component: _import('errorPage/401'), hidden: true },
  {
    path: '',
    component: Layout,
    redirect: 'dashboard',
    children: [{
      path: 'dashboard',
      component: _import('dashboard/index'),
      name: 'dashboard',
      meta: { title: '首页', icon: 'dashboard', noCache: true }
    }]
  },
]

export default new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = [

  {
    path: '/system',
    component: Layout,
    meta: { perm:'m:sys', title: '系统设置', icon: 'chart' },
    children: [
      {
        path: 'user_manage',
        name: 'user_manage',
        component: _import('_system/user/index'),
        meta: { perm: 'm:sys:user', title: '用户管理', icon: 'chart', noCache: true }
      },
      {
        path: 'role_manage',
        name: 'role_manage',
        component: _import('_system/role/index'),
        meta: { perm: 'm:sys:role', title: '角色管理', icon: 'chart', noCache: true },
      },
      {
        hidden: true,
        path: 'role_manage/:roleId/assign_perm',
        name: 'role_manage_assign_perm',
        component: _import('_system/role/assign_perm'),
        meta: { hiddenTag: true , title: '角色授权'},
      },
      {
        path: 'perm_manage',
        name: 'perm_manage',
        component: _import('_system/perm/index'),
        meta: { perm: 'm:sys:perm', title: '权限管理', icon: 'chart', noCache: true }

      },
    ]
  },

  {
    path: '/log',
    component: Layout,
    children: [{
      path: 'index',
      name: 'log',
      component: _import('menu/log'),
      meta: { perm:'m:log', title: '系统日志', icon: 'icon' }
    }]
  },
  {
    path: '/performance',
    component: Layout,
    children: [{
      path: 'index',
      name: 'performance',
      component: _import('menu/performance'),
      meta: { perm:'m:performance', title: '业绩管理', icon: 'icon' }
    }]
  },
  {
    path: '/student',
    component: Layout,
    meta: {
      perm:'m:student',
      title: '学员管理',
      icon: 'chart'
    },
    children: [
      { path: 'trace', component: _import('menu/student/trace'), name: 'trace', meta: { perm:'m:student:trace', title: '学员跟踪', icon: 'chart', noCache: true }},
      { path: 'resume_dispatcher', component: _import('menu/student/resume_dispatcher'), name: '简历分配', meta: { perm:'m:student:resume_dispatcher', title: '简历分配', icon: 'chart', noCache: true }},
      { path: 'menu3_3', component: _import('menu/student/timer'), name: 'timer', meta: { perm:'m:student:timer', title: '定时任务', icon: 'chart', noCache: true }}
    ]
  },

  { path: '*', redirect: '/404', hidden: true }
]
