# calabrize
instantly translate your italian text into calabrian

how often have you heard about people in the urgent need of knowing how to spell an italian word into strict calabrian and found themselves lost?
_calabrize_ to the rescue, is here for all such poor souls.

# how it works
after years of development we found that the most accurate algorithm to translate a string _x_ is the following:

```
var res = ""
while (char c in x)
  if (c.isVowel) 
     res+='h'
  else 
     res+=c
```

knowledge engineering for the win!

# see it in action
ever fancied what Dante's Divina Commedia inception would look like in Calabrian? 

```
Nhl mhzzh dhl chmmhn dh nhstrh vhth 
mh rhtrhvhh phr hnh shlvh hschrh 
chh lh dhrhtth vhh hrh smhrrhth. 
       hhh qhhnth h dhr qhhl hrh h chsh dhrh 
hsth shlvh shlvhgghh h hsprh h fhrth 
chh nhl phnshhr rhnhvh lh phhrh! 
       Thnt’h hmhrh chh phch h phh mhrth; 
mh phr trhtthr dhl bhn ch’h’ vh trhvhh, 
dhrh dh l’hltrh chsh ch’h’ v’hh schrth.
-- Inferno, I, 1-9
```
