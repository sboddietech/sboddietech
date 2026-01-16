using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class TargetController : MonoBehaviour
{
    ParticleSystem ps;
    Collider collide;
    MeshRenderer renderer;
    int total;
    Text hits;
    // Start is called before the first frame update
    void Start()
    {
        ps = GetComponent<ParticleSystem>();
        renderer = GetComponent<MeshRenderer>();
        collide = GetComponent<Collider>();
        hits = GameObject.Find("Hits").GetComponent<Text>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnTriggerEnter(Collider other )
    {
        GameObject otherGO = other.gameObject;
        if ((otherGO.tag == "Bullet"))
        {
           collide.enabled = false;
            renderer.enabled = false ;
            ps.Play();
            //Destroy(gameObject);
            total++;
            hits.text = "Hits: " + total;

        }
    }
}
