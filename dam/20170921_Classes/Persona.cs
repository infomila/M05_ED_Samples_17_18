using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace _20170921_Classes
{
    class Persona
    {
        //---------------------------------
        // atributs
        //---------------------------------
        #region attributs
        private string mNom;
        private string mCognom;
        private DateTime mDataNaixement;
        private string mNIF;
        private long mID;
        #endregion
        //-----------------------------
        // Propietats
        //------------------------------        
        #region properties
        public string Cognom
        {
            get { return mCognom; }
            set {
                if (value == null || value.Trim().Length < 2)
                    throw new Exception("Cognom erroni");
                mCognom = value;
            }
        }
        public string Nom
        {
            get { return mNom; }
            set
            {
                if (value == null || value.Trim().Length < 2)
                    throw new Exception("Nom erroni");
                mNom = value;
            }
        }
        public string NIF
        {
            get { return mNIF; }
            set
            {
                if (!validaNIF(value))
                    throw new Exception("NIF erroni");
                mNIF = value;
            }
        }
        public long ID
        {
            get { return mID; }
            set
            {
                if (value<=0)
                    throw new Exception("ID erroni");
                mID = value;
            }
        }
        public DateTime DataNaixement
        {
            get { return mDataNaixement; }
            set
            {
                if (value == null || value>DateTime.Today)
                    throw new Exception("Data errònia");
                mDataNaixement = value;
            }
        }
        
        public int Edat
        {
            get
            {
                int anys = DateTime.Now.Year - mDataNaixement.Year;
                if( DateTime.Now.Month< mDataNaixement.Month ||
                    (DateTime.Now.Month == mDataNaixement.Month
                    && DateTime.Now.Day < mDataNaixement.Day))
                {
                    anys--;
                }
                return anys;
            }
        } 
        
        #endregion


        //-----------------------------
        // Constructors
        //------------------------------
        #region constructors
        public Persona(long pID, string pNIF, string pNom, string pCognom, DateTime pDataNaixement)
        {            
            ID = pID;
            NIF = pNIF;
            Nom = pNom;
            Cognom = pCognom;
            DataNaixement = pDataNaixement;
        }
        #endregion
        //-----------------------------
        // Mètodes
        //------------------------------
        #region metodes
        public string GetInforme()
        {
            return mNom + " ha nascut el " +
                mDataNaixement.ToString("dd/MM/yyyy")
                + " i té el NIF " + mNIF;
        }


        //----- Validació de NIF--------------------------------
        private const string correspondencia = "TRWAGMYFPDXBNJZSQVHLCKET";
        public  bool validaNIF(string NIF)
        {
            string valueToValid = NIF;
            string initialLetter = string.Empty;
            string controlDigit = string.Empty;
            int dniNumber;

            // Value is not null.
            if (!string.IsNullOrEmpty(valueToValid))
            {
                // The excess characters are deleted.
                string nif = DeleteInvalidChars(valueToValid);

                // Check NIF length.
                if (nif.Length != 9)
                    return false;

                // Check NIF format.
                if (!System.Text.RegularExpressions.Regex.IsMatch(nif, @"[0-9]{8,10}[" + correspondencia + "]$"))
                    return false;

                initialLetter = string.Empty;
                Int32.TryParse(nif.Substring(0, 8), out dniNumber);
                controlDigit = nif.LastOrDefault().ToString();

                // Check letter.
                if (controlDigit != GetNIFLetter(dniNumber))
                    return false;
                
            }
            return true;
        }
        
        private string DeleteInvalidChars(string numero)
        {
            // All characters that are not numbers or letters.
            string chars = @"[^\w]";
            Regex regex = new Regex(chars);
            return regex.Replace(numero, string.Empty).ToUpper();
        }

        /// <summary>
        /// Returns the letter of a NIF.
        /// </summary>
        /// <param name="numero">NIF Number</param>
        /// <returns>Control letter</returns>
        private string GetNIFLetter(int numeroDNI)
        {
            int index = numeroDNI % 23;
            return correspondencia[index].ToString();
        }

        #endregion
    }
}
