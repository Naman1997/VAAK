const int flexPin1 = A0; 
const int flexPin2 = A1;

int value, i;
int initialSum1=0, sum1;
int initialSum2=0, sum2;
char a,b;

void setup()
{
  pinMode(flexPin1, INPUT);
  pinMode(flexPin2, INPUT);
  Serial.begin(9600);   
  for(i=0; i<10; ++i)
  {
    value=analogRead(flexPin1);
    initialSum1 += value;
    value=analogRead(flexPin2);
    initialSum2 += value;
  }
}

void loop()
{
  sum1=sum2=0;
  a=b='1';
  for(i=0; i<10; ++i) 
  {
    value = analogRead(flexPin1);
    sum1 += value;
    value = analogRead(flexPin2);
    sum2 += value;
  }
  delay(125);
  if ( (sum1-initialSum1)>100 )
    a='0';
  if ( (sum2-initialSum2)>100 )
    b='0';
  if(a=='1'&&b=='1')
      Serial.write("NO\n");
    else if(a=='0'&&b=='0')
      Serial.write("A\n");
    else if(a=='0'&&b=='1')
      Serial.write("B\n");
    else if(a=='1'&&b=='0')
      Serial.write("C\n"); 
}