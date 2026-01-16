using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class WallController : MonoBehaviour
{
    Text misses;
    int total;
    // Start is called before the first frame update
    void Start()
    {
        misses = GameObject.Find("Miss").GetComponent<Text>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnTriggerEnter(Collider other)
    {
        GameObject otherGO = other.gameObject;
        if ((otherGO.tag == "Bullet"))
        {
            total++;
            misses.text = "Miss: " + total;
            //Destroy(gameObject);
        }
    }
}
