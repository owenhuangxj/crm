import store from '@/store'

/**
 * @param {Array} value
 * @returns {Boolean}
 * @example see @/views/permission/directive.vue
 */
export default function checkPermission(value) {
  if (value && value instanceof Array && value.length > 0) {
    const roles = store.getters && store.getters.roles
    /*for(let i = 0 ; i<roles.length;i++){
      let role = roles[i].val;
      for(let j = 0 ; j < value.length;j++){
        if(value[j] == role) return true;
      }
    }
    return false;*/
    const permissionRoles = value
    const hasPermission = roles.some(function(role){
      return permissionRoles.includes(role.val)
    })
    if (!hasPermission) {
      return false
    }
    return true
  } else {
    console.error(`need roles! Like v-permission="['admin','editor']"`)
    return false
  }
}
