using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ExplosionController : MonoBehaviour
{
    public float radius;
    public float power;
    // Start is called before the first frame update
    void Start()
    {
        Collider[] colliders = Physics.OverlapSphere(transform.position, radius);
        foreach(Collider c in colliders)
        {
            if (c.attachedRigidbody != null && !wallBlocked(c.transform.position))
            {
                Vector3 v = c.transform.position - transform.position;
                v.y = 0;
                if (v.magnitude > 0)
                {
                    Vector3 force = (power / v.magnitude) * v.normalized;
                    c.attachedRigidbody.AddForce(force, ForceMode.Impulse);


                    if (c.tag == "Player")
                    {
                        c.GetComponent<PlayerController>().damage(force.magnitude);
                    }else if(c.tag == "Enemy")
                    {
                        Destroy(c.gameObject);
                    }
                }
            }
        }
    }

    private bool wallBlocked(Vector3 targetPos)
    {
        RaycastHit hitInfo;
        if(Physics.Linecast(transform.position, targetPos, out hitInfo))
        {
            if(hitInfo.collider.tag == "Wall")
            {
                return true;
            }
        }
        return false;
           
    }

    // Update is called once per frame
  
}
