# springboot-test

- Test springboot
- Passi da eseguire per il test:
  - Una volta che viene creato il db chiamare questo endpoint http://localhost:8080/api/v1/users/init per popolare la tabella con un semplice dato fittizzio
  - Chiamare l'endpoint http://localhost:8080/api/v1/users/findby/name/francesco per ottenere solo le informazioni relative all'utente
  - Chiamare l'endpoint http://localhost:8080/api/v1/users/findby2/name/francesco per ottenere solo le informazioni relative all'utente + le carte
