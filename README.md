# UnicornMaster-CatchUnicornGame
Unicorn Master - Unicorn Yakalama Oyunu ( Catch Unircorn Game )

![Unicorn Master](https://lh3.googleusercontent.com/MOLnQHORc6ipThyohXtt8XlfWVHdPBKwXSuHPr56yTGcWY4TrVIEuVCVrQVu2OtccFfZ=s180-rw)

## English:

**Score System** : Every touch one score point <br/>
**Candy System** : Every 10 score point gives you a candy<br/>
**Market System** : Unicorn skins can be purchased with candys <br/>
**Level System** : Candy connected level system<br/>
**Difficulty System** : Changeable game speed <br/>
**Sound System** : Every 5 score point makes a bubble sound  <br/>

<br/>


 #### LEVEL SYSTEM

```javascript
        if(candyScore>=0 && candyScore < 100){
            accFor.setText("Unicorn Master");
        }
        if(candyScore>=100 && candyScore < 200){
            accFor.setText("Baby Unicorn Master");
        }
        if(candyScore>=200 && candyScore < 300){
            accFor.setText("Student Unicorn Master");
        }
        if(candyScore>=300 && candyScore < 400){
            accFor.setText("Legandary Unicorn Master");
        }
        if(candyScore>=400 && candyScore < 500){
            accFor.setText("Fantastic Unicorn Master");
        }
        if(candyScore>=500 && candyScore < 600){
            accFor.setText("Mystic Unicorn Master");
        }
        if(candyScore>=600){
            accFor.setText("Professor Unicorn Master");
        }
```



