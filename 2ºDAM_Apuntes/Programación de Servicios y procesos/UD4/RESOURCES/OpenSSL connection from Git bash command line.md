`openssl s_client -connect smtp.gmail.com:465 -crlf -ign_eof`
**Connecting to 173.194.76.109**  
CONNECTED(000001BC)  
........  
---  
read R BLOCK  
---  
Post-Handshake New Session Ticket arrived:  
SSL-Session:  
...     
---  
read R BLOCK  
**220 smtp.gmail.com ESMTP ffacd0b85a97d-38dc565d62dsm11523715f8f.93 - gsmtp**  
helo noemi  
**250 smtp.gmail.com at your service**  
auth login  
**334 VXNlcm5hbWU6**  
[user base64]  
**334 UGFzc3dvcmQ6**  
[password base 64]  
**235 2.7.0 Accepted**  
mail from: <xxx@iessanclemente.net>  
**250 2.1.0 OK ffacd0b85a97d-38dc565d62dsm11523715f8f.93 - gsmtp**  
rcpt to: <nvarela@yopmail.com>  
**250 2.1.5 OK ffacd0b85a97d-38dc565d62dsm11523715f8f.93 - gsmtp**  
data  
354 Go ahead ffacd0b85a97d-38dc565d62dsm11523715f8f.93 - gsmtp  
From:Noemi Varela<xxx@iessanclemente.net>  
To:Noemi Yopmail<nvarela@yopmail.com>  
Subject: This is a mail using openssl and Gmail SMTP

This mail is from me.  
.  
**250 2.0.0 OK  1739206376 ffacd0b85a97d-38dc565d62dsm11523715f8f.93 - gsmtp**