const { createApp, ref } = Vue

createApp({
  setup() {
    const script = ref(localStorage.script || '')
    const imageSrc = ref('')

    const showImage = async () => {
      localStorage.script = script.value
      const image = await axios.post("/api/uml/image", { script: script.value })
      imageSrc.value = image.data
      const offcanvas = new bootstrap.Offcanvas(document.getElementById("offcanvas"))
      offcanvas.show()
    }

    return {
      script,
      imageSrc,
      showImage,
    }
  },
}).mount("#root")
