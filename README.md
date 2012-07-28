Log4j-Unix-socket-appender-for-JSON
===================================

Funguje to asi tak, ze spustis najprv MyServerSocket a potom App. V MyServerSocket sa vytvori ServerSocket a nastavi sa aby pocuval na zadanej adrese a porte. V App sa vytvori logger, ku ktoremu pripojim MySocketAppender. Ked logger nieco zapise, appender vytvori Socket s tou istou adresou a portom ako ma ServerSocket a zapise sa do neho sprava. ServerSocket ju prijme a zapise do suboru.