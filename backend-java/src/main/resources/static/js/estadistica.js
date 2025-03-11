const getOptionChart1=()=>{
    return{
       
          tooltip: {
            trigger: 'item'
          },
          
          series: [
            {
              
              type: 'pie',
              radius: '50%',
              data: [
                { value: 1, name: 'Cámara Casación' },
                { value: 9, name: 'Cámara Federal' },
                { value: 72, name: 'Juzgados Federales' },
                { value: 11, name: 'Juzgados Penales Económico' },
                { value: 24, name: 'Tribunales Federales' },
                { value: 3, name: 'Tribunales Penales Económico' }
              ],
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
}};
const getOptionChart2=()=>{
    return{
       
          tooltip: {
            trigger: 'item'
          },
      toolbox:{
        feature:{
        saveAsImage:{
        }
        }
      },
          series: [
            {
              
              type: 'pie',
              radius: '50%',
              data: [
                { value: 1, name: 'Cámara Casación' },
                { value: 7, name: 'Cámara Federal' },
                { value: 63, name: 'Juzgados Federales' },
                { value: 11, name: 'Juzgados Penales Económico' },
                { value: 16, name: 'Tribunales Federales' },
                { value: 2, name: 'Tribunales Penales Económico' }
              ],
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
}};

const initChars=()=>{
    const chart1=echarts.init(document.getElementById('chart1'));
    const chart2=echarts.init(document.getElementById('chart2'));

    chart1.setOption(getOptionChart1());
    chart2.setOption(getOptionChart2());
}

window.addEventListener('load', ()=>{
    initChars();
    });