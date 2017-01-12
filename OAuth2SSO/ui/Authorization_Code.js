import React from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import Login from './components/Login.jsx';
import injectTapEventPlugin from 'react-tap-event-plugin';
import $ from 'jquery';

injectTapEventPlugin();
class App extends React.Component {

  constructor(props) {
    super(props);

    this.state = {
      content:''
    }
  }

  componentDidMount(){
    // alert('did mount');
  }

  componentWillMount(){
    let url = window.location.search,
        code = url.slice(0,6),
        codeURL = "http://192.168.1.244:9999/OAuth2-SSO/oauth/token",
        codeCompare = url.substring(6,url.length);

    if(code !== "?code="){
      window.location="http://localhost:9999/OAuth2-SSO/oauth/authorize?client_id=xke_auth_code&response_type=code&redirect_uri=http://localhost:8080";
    }else{
      // alert(codeCompare)
      let payload = {
              "grant_type":"authorization_code",
              "code":codeCompare,
              "redirect_uri":"http://192.168.2.246:8080",
              "client_id":"acme"
            }

      $.ajax({
              url: codeURL,
              type: 'POST',
              data: payload,
              dataType: "json",
              beforeSend: function(xhr){xhr.setRequestHeader('Authorization', 'Basic eGViaWFfeGtlOnhlYmlhX3hrZV9zZWNyZXQ=')},
              contentType: 'application/x-www-form-urlencoded',
              success: function(data){
                console.log('data',data)
              },
              error: function(data,textStatus) {
                alert(textStatus)
                alert(JSON.stringify(data)); //or whatever
              }
            });
          }
        }

   render() {
      return (
         <div className = "mainWrapper">
            <MuiThemeProvider>
               <Login/>
             </MuiThemeProvider>
         </div>
      );
   }


}



export default App;
