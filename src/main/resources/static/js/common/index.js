const { createApp } = Vue

createApp({
  setup() {
    const isActive = (path, isDefault = false) => window.location.pathname.startsWith(path) || (isDefault && window.location.pathname === '/')

    return {
      isActive,
    }
  },
}).mount("#root-navigation")
