import store from '@/store'

export default{
  inserted(el, binding, vnode) {
    const { value } = binding
    const roles = store.getters && store.getters.roles

    if (value && value instanceof Array && value.length > 0) {
      const permissionRoles = value

      const hasPermission = roles.some(role => {
        return permissionRoles.includes(role.val)
      })

      /*let hasPermission = false;
      for(let i = 0 ; i<roles.length;i++){
        let role = roles[i].val;
        for(let j = 0 ; j < value.length;j++){
          if(value[j] == role) {
            hasPermission = true;
            return true;
          }
        }
      }*/
      if (!hasPermission) {
        el.parentNode && el.parentNode.removeChild(el)
      }
    } else {
      throw new Error(`need roles! Like v-permission="['admin','editor']"`)
    }
  }
}
