import { cloneDeep } from "https://esm.sh/es-toolkit@%5E1"

const { createApp, ref } = Vue

const defaultColumn = {
  name: '',
}

const defaultRelation = {
  from: '',
  fromType: relationEdgeTypeEnumList[0],
  to: '',
  toType: relationEdgeTypeEnumList[0],
  lineType: relationLineTypeEnumList[0],
  lineLength: 2,
}

const defaultTable = {
  name: '',
  columnList: [cloneDeep(defaultColumn)],
  relationList: []
}

createApp({
  setup() {
    const errorList = ref([])
    const isError = (field) => errorList.value.filter(e => e.field === field).length !== 0
    const getErrorMessageList = (field) => errorList.value.filter(e => e.field === field).map(e => e.message)

    const tableList = ref(localStorage.tableList ? JSON.parse(localStorage.tableList) : [cloneDeep(defaultTable)])
    const imageSrc = ref('')

    const relationOptionList = (tableIndex) => tableList.value.filter((_, i) => i != tableIndex).map(table => table.name)

    const addTable = () => tableList.value.push(cloneDeep(defaultTable))
    const deleteTable = (deleteTableIndex) => tableList.value.splice(deleteTableIndex, 1)
    const addColumn = (tableIndex) => tableList.value[tableIndex].columnList.push(cloneDeep(defaultColumn))
    const deleteColumn = (tableIndex, deleteColumnIndex) => tableList.value[tableIndex].columnList.splice(deleteColumnIndex, 1)
    const addRelation = (tableIndex) => tableList.value[tableIndex].relationList.push(cloneDeep(defaultRelation))
    const deleteRelation = (tableIndex, deleteRelationIndex) => tableList.value[tableIndex].relationList.splice(deleteRelationIndex, 1)
    const save = () => {
      localStorage.tableList = JSON.stringify(tableList.value)
    }
    const showImage = async () => {
      save()
      const response = await axios.post("/api/uml/image/er", { "tableList": tableList.value }, {
        validateStatus: function(status) {
          return status < 500;
        }
      })
      if (response.status === 400) {
        errorList.value = response.data
        return
      }
      imageSrc.value = response.data
      const offcanvas = new bootstrap.Offcanvas(document.getElementById("offcanvas"))
      offcanvas.show()
    }

    return {
      errorList,
      isError,
      getErrorMessageList,
      tableList,
      imageSrc,
      relationOptionList,
      addTable,
      deleteTable,
      addColumn,
      deleteColumn,
      addRelation,
      deleteRelation,
      save,
      showImage,
    }
  },

  //  mountedColumnSwapyContainer(tableIndex) {
  //    const columnSwapy = Swapy.createSwapy(document.querySelector(`.columnSwapyContainer-${tableIndex}`))
  //    columnSwapy.enable(true)
  //    columnSwapy.onSwap((event) => {
  //      this.tableList[tableIndex].columnList = event.data.array.map(data => this.tableList[tableIndex].columnList[_.last(data.itemId.split('-'))])
  //    })
  //  },
}).mount("#root")
