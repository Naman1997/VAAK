const int flexPin1 = A0; 
const int flexPin2 = A1;
const int flexPin3 = A2; 
const int flexPin4 = A3;
const int flexPin5 = A4; 

int value, i;
int initialSum1=0, sum1;
int initialSum2=0, sum2;
int initialSum3=0, sum3;
int initialSum4=0, sum4;
int initialSum5=0, sum5;
String a,b,c,d,e;

void setup()
{
  pinMode(flexPin1, INPUT);
  pinMode(flexPin2, INPUT);
  pinMode(flexPin3, INPUT);
  pinMode(flexPin4, INPUT);
  pinMode(flexPin5, INPUT);
  Serial.begin(9600);   
  for(i=0; i<10; ++i)
  {
    value=analogRead(flexPin1);
    initialSum1 += value;
    value=analogRead(flexPin2);
    initialSum2 += value;
    value=analogRead(flexPin3);
    initialSum3 += value;
    value=analogRead(flexPin4);
    initialSum4 += value;
    value=analogRead(flexPin5);
    initialSum5 += value;
  }
}

void loop()
{
  sum1=sum2=sum3=sum4=sum5=0;
  a=b=c=d=e="1";
  for(i=0; i<10; ++i) 
  {
    value = analogRead(flexPin1);
    sum1 += value;
    value = analogRead(flexPin2);
    sum2 += value;
    value = analogRead(flexPin3);
    sum3 += value;
    value = analogRead(flexPin4);
    sum4 += value;
    value = analogRead(flexPin5);
    sum5 += value;
  }
  delay(125);
  if ( (sum1-initialSum1)>100 )
    a="0";
  if ( (sum2-initialSum2)>100 )
    b="0";
  if ( (sum3-initialSum3)>100 )
    c="0";
  if ( (sum4-initialSum4)>100 )
    d="0";
  if ( (sum5-initialSum5)>100 )
    e="0";
  String s=a+b+c+d+e;
  if(s=="11111")
    Serial.write("NO\n");
  else if(s=="00001")
    Serial.write("A\n");
  else if(s=="00010")
    Serial.write("B\n"); 
  else if(s=="00011")
    Serial.write("C\n");
  else if(s=="00100")
    Serial.write("D\n");
  else if(s=="00101")
    Serial.write("E\n");
  else if(s=="00110")
    Serial.write("F\n");
  else if(s=="00111")
    Serial.write("G\n");
  else if(s=="01000")
    Serial.write("H\n");
  else if(s=="01001")
    Serial.write("I\n");
  else if(s=="01010")
    Serial.write("J\n");
  else if(s=="01011")
    Serial.write("K\n");
  else if(s=="01100")
    Serial.write("L\n");
  else if(s=="01101")
    Serial.write("M\n");
  else if(s=="01110")
    Serial.write("N\n");
  else if(s=="01111")
    Serial.write("O\n");
  else if(s=="10000")
    Serial.write("P\n");
  else if(s=="10001")
    Serial.write("Q\n");
  else if(s=="10010")
    Serial.write("R\n");
  else if(s=="10011")
    Serial.write("S\n");
  else if(s=="10100")
    Serial.write("T\n");
  else if(s=="10101")
    Serial.write("U\n");
  else if(s=="10110")
    Serial.write("V\n");
  else if(s=="10111")
    Serial.write("W\n");
  else if(s=="11000")
    Serial.write("X\n");
  else if(s=="11001")
    Serial.write("Y\n");
  else if(s=="11010")
    Serial.write("Z\n");
}
