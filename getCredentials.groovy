def Message getCredentials( Message message ) {
    
    def service = ITApiFactory.getApi(SecureStoreService.class, null)
    def credential = service.getUserCredential("UPLOADED_CREDENTIAL_IN_SECURE_STORE")
    if (credential == null){
        throw new IllegalStateException("No credential found for alias 'UPLOADED_CREDENTIAL_IN_SECURE_STORE'")
    }
    
    String userName = credential.getUsername()
    String password = new String(credential.getPassword())
            
    message.setProperty("p_username", userName)
    message.setProperty("p_password", password)
    
    message
}
