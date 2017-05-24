package com.px.rxandroiddmeo;


public class WeatherInfo
{

        @Override
        public String toString()
        {
            return "Weatherinfo{" +
                    "Radar='" + Radar + '\'' +
                    ", SD='" + SD + '\'' +
                    ", WD='" + WD + '\'' +
                    ", WS='" + WS + '\'' +
                    ", WSE='" + WSE + '\'' +
                    ", city='" + city + '\'' +
                    ", cityid='" + cityid + '\'' +
                    ", isRadar='" + isRadar + '\'' +
                    ", njd='" + njd + '\'' +
                    ", qy='" + qy + '\'' +
                    ", rain='" + rain + '\'' +
                    ", temp='" + temp + '\'' +
                    ", time='" + time + '\'' +
                    '}';
        }

        /**
         * Radar : JC_RADAR_AZ9010_JB
         * SD : 17%
         * WD : 东南风
         * WS : 1级
         * WSE : 1
         * city : 北京
         * cityid : 101010100
         * isRadar : 1
         * njd : 暂无实况
         * qy : 1011
         * rain : 0
         * temp : 18
         * time : 17:05
         */

        private String Radar;
        private String SD;
        private String WD;
        private String WS;
        private String WSE;
        private String city;
        private String cityid;
        private String isRadar;
        private String njd;
        private String qy;
        private String rain;
        private String temp;
        private String time;

        public String getRadar()
        {
            return Radar;
        }

        public void setRadar(String Radar)
        {
            this.Radar = Radar;
        }

        public String getSD()
        {
            return SD;
        }

        public void setSD(String SD)
        {
            this.SD = SD;
        }

        public String getWD()
        {
            return WD;
        }

        public void setWD(String WD)
        {
            this.WD = WD;
        }

        public String getWS()
        {
            return WS;
        }

        public void setWS(String WS)
        {
            this.WS = WS;
        }

        public String getWSE()
        {
            return WSE;
        }

        public void setWSE(String WSE)
        {
            this.WSE = WSE;
        }

        public String getCity()
        {
            return city;
        }

        public void setCity(String city)
        {
            this.city = city;
        }

        public String getCityid()
        {
            return cityid;
        }

        public void setCityid(String cityid)
        {
            this.cityid = cityid;
        }

        public String getIsRadar()
        {
            return isRadar;
        }

        public void setIsRadar(String isRadar)
        {
            this.isRadar = isRadar;
        }

        public String getNjd()
        {
            return njd;
        }

        public void setNjd(String njd)
        {
            this.njd = njd;
        }

        public String getQy()
        {
            return qy;
        }

        public void setQy(String qy)
        {
            this.qy = qy;
        }

        public String getRain()
        {
            return rain;
        }

        public void setRain(String rain)
        {
            this.rain = rain;
        }

        public String getTemp()
        {
            return temp;
        }

        public void setTemp(String temp)
        {
            this.temp = temp;
        }

        public String getTime()
        {
            return time;
        }

        public void setTime(String time)
        {
            this.time = time;
        }
}
