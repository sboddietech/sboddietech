using System.Collections;
using System.Collections.Generic;
using UnityEngine.UI;
using UnityEngine;

public class InventoryMgr : MonoBehaviour
{
    public KeyCode cycleInventoryKey;
    public int currentIndex = 0;
    public GameObject[] allPrefabs;
    public bool[] allOwned;
    //Rigidbody rigid;

    public GameObject instant;

    

    // Start is called before the first frame update
    void Start()
    {
       //rigid = GetComponent<Rigidbody>();   
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(cycleInventoryKey))
        {
            currentIndex++;
            if(currentIndex > 1)
            {
                currentIndex = 0;
            }
            if (currentIndex == 0)
            {
                allPrefabs[0].SetActive(true);
                allPrefabs[1].SetActive(false);
                GameObject g = Instantiate(allPrefabs[0]);
                g.transform.SetParent(transform);
                g.transform.localPosition = Vector3.zero;
                g.transform.localRotation = Quaternion.identity;
                Destroy(GameObject.FindWithTag("Rifle"));


            }
            else if (currentIndex == 1)
            {
                allPrefabs[1].SetActive(true);
                allPrefabs[0].SetActive(false);
                GameObject g = Instantiate(allPrefabs[1]);
                g.transform.SetParent(transform);
                g.transform.localPosition = Vector3.zero;
                g.transform.localRotation = Quaternion.identity;
                Destroy(GameObject.FindWithTag("Pistol"));

            }
        }


    }



}