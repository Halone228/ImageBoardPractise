resp = fetch(document.location.href,{
    method: 'POST'
})
if (resp.ok){
    let json = await resp.json();
}
app1 = Vue.createApp({
    el: '#item',
    data(){
        return {
            items: json
        }
    }
})