This recipe fixes libgcrypt-based software throwing "illegal instruction" on Galileo.
That's specifically affecting AES cipher. The solution is to disable AES-NI support
in libgcrypt. VIA's Padlock is disabled also just in case.
